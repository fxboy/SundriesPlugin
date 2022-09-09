package icu.weboys.sundriesplugin.config;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.components.*;
import com.intellij.util.xmlb.XmlSerializerUtil;
import icu.weboys.sundriesplugin.obj.QS;
import icu.weboys.sundriesplugin.core.quicksearch.QuickSearchAction;
import icu.weboys.sundriesplugin.core.quicksearch.QuickSearchSetting;
import org.jetbrains.annotations.Nullable;

import java.nio.charset.Charset;
import java.util.*;

@State(name = "QuickSearchConfig",storages = {@Storage(value = "sundries-quicksearch-t-config.xml", roamingType = RoamingType.DISABLED)})
public class QuickSearchConfig implements PersistentStateComponent<QuickSearchConfig> {
    String settingJson = "eyJHb29nbGUiOnsiZGVzIjoiaHR0cHM6Ly93d3cuZ29vZ2xlLmNvbS8iLCJpY29uIjoiL2ljb25zL0dvb2dsZS5zdmciLCJuYW1lIjoiR29vZ2xlIiwidXJsIjoiaHR0cHM6Ly93d3cuZ29vZ2xlLmNvbS9zZWFyY2g/cT0lcyZpZT1VVEYtOCIsInZpc2libGUiOnRydWUsInkiOmZhbHNlfSwiQmFpZHUiOnsiZGVzIjoi55m+5bqm5LiA5LiLLOS9oOWwseefpemBkyIsImljb24iOiIvaWNvbnMvYmFpZHUuc3ZnIiwibmFtZSI6IkJhaWR1IiwidXJsIjoiaHR0cHM6Ly93d3cuYmFpZHUuY29tL3M/d2Q9JXMiLCJ2aXNpYmxlIjp0cnVlLCJ5IjpmYWxzZX0sIkNTRE4iOnsiZGVzIjoi5oiQ5bCx5LiA5Lq/5oqA5pyv5Lq6IiwiaWNvbiI6Ii9pY29ucy9jc2RuLnN2ZyIsIm5hbWUiOiJDU0ROIiwidXJsIjoiaHR0cHM6Ly9zby5jc2RuLm5ldC9zby9zZWFyY2g/cT0lcyIsInZpc2libGUiOnRydWUsInkiOmZhbHNlfSwiQmFpZHUgS2FpZmEiOnsiZGVzIjoi55m+5bqm5byA5Y+R6ICF5pCc57Si5byV5pOOIiwiaWNvbiI6Ii9pY29ucy95dWFuLnN2ZyIsIm5hbWUiOiJCYWlkdSBLYWlmYSIsInVybCI6Imh0dHBzOi8va2FpZmEuYmFpZHUuY29tL3NlYXJjaFBhZ2U/d2Q9JXMiLCJ2aXNpYmxlIjp0cnVlLCJ5IjpmYWxzZX0sIlN0YWNrb3ZlcmZsb3ciOnsiZGVzIjoiaHR0cHM6Ly9zdGFja292ZXJmbG93LmNvbSIsImljb24iOiIvaWNvbnMvc3RhY2tvdmVyZmxvdy5zdmciLCJuYW1lIjoiU3RhY2tvdmVyZmxvdyIsInVybCI6Imh0dHBzOi8vc3RhY2tvdmVyZmxvdy5jb20vc2VhcmNoP3E9JXMiLCJ2aXNpYmxlIjp0cnVlLCJ5IjpmYWxzZX19";

    public Map<String, QS> objs = new HashMap<>();

    public Map<String, QS> getObjs() {
        return objs;
    }

    public void setObjs(Map<String, QS> objs) {
        this.objs = objs;
    }

    public String getSettingJson() {
        return settingJson;
    }

    public void setSettingJson(String settingJson) {
        this.settingJson = settingJson;
    }

// ===================================================

    public String add(String name, String des, String url, String icon){
        objs.put(name,new QS(name,des,url,icon,true,true));
        return save();
    }

    public String remove(String name){
        if(!objs.get(name).getY()){
           return this.settingJson;
        }
        objs.remove(name);
        return save();
    }

    public String save(){
        try{
            return  new String(Base64.getEncoder().encode(JSON.toJSONString(objs).getBytes("utf-8")),"utf-8");
        }catch (Exception ex){
            return "";
        }
    }

    public String upt(String name,String des, String url, String icon){
        QS s = objs.get(name);
        s.setDes(des);
        s.setUrl(url);
        s.setIcon(icon);
        return save();
    }

    public String setVisible(String name){
        QS s = objs.get(name);
        s.setVisible(!s.getVisible());
        return save();
    }
    // ===================================================

    public List<String> getObjNameList(){
        return new ArrayList<>(objs.keySet());
    }

    public List<QS> getObjsList(){
        return new ArrayList<>(objs.values());
    }

    public List<AnAction> getRegAnAction(Boolean i){
        List<AnAction> list = new ArrayList<>();
        for (String s : objs.keySet()) {
            if(!objs.get(s).getVisible()){continue;}
            list.add(new QuickSearchAction(objs.get(s).getName(),objs.get(s).getDes(),objs.get(s).getUrl(),objs.get(s).getIcon()));
        }
        if(i){
            list.add(new QuickSearchSetting());
        }
        return list;
    }


    // ===================================================
    public void init(){
        if(objs.size() == 0){
            Map<String, QS> s =  JSON.parseObject(new String(Base64.getDecoder().decode(settingJson), Charset.forName("utf-8")), new TypeReference<Map<String, QS>>(){});
            objs.putAll(s);
        }
    }
    @Nullable
    public static QuickSearchConfig getInstance() {
        QuickSearchConfig c = ServiceManager.getService(QuickSearchConfig.class);
        c.init();
        return c;
    }

    public String stateValue;

    @Nullable
    @Override
    public QuickSearchConfig getState() {
        return this;
    }

    @Override
    public void loadState(QuickSearchConfig state) {
        XmlSerializerUtil.copyBean(state, this);
    }

}