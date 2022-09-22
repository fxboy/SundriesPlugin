package icu.weboys.sundriesplugin.config

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.editor.Editor
import com.intellij.openapi.project.Project
import icu.weboys.sundriesplugin.core.quicksearch.QuickSearchAction
import icu.weboys.sundriesplugin.core.quicksearch.QuickSearchSetting
import icu.weboys.sundriesplugin.core.quicksearch.obj.QsObj
import icu.weboys.sundriesplugin.core.translate.TranslateService
import icu.weboys.sundriesplugin.core.translate.obj.TsObj
import icu.weboys.sundriesplugin.core.translate.service.BaiduTranslate
import icu.weboys.sundriesplugin.core.translate.service.GoogleTranslate
import icu.weboys.sundriesplugin.pobj.EditorSelectInfo

class ConfigFactory {
    var s = PluginConfig.getInstance().state;
    fun getQsConfig():MutableMap<String, QsObj> {
       return s!!.qslist;
    }

    fun getTsConfig():MutableMap<String,TsObj>{
        return s!!.tslist;
    }

    fun getDefTs():String{
        return s!!.defTranslate;
    }

    fun setDefTs(key:String){
        s!!.defTranslate = key;
    }
}

object TsConfigFactory{
    var config = ConfigFactory();

    fun getDefault():String{
        return config.getDefTs();
    }

    fun getTsObj(key: String):TsObj{
        return config.getTsConfig()[key]!!;
    }

    fun getList():ArrayList<String>{
        return ArrayList(config.getTsConfig().keys);
    }

    // 修改配置
    fun set(key:String,obj:TsObj){
        if(config.getTsConfig().containsKey(key)){
            var t = config.getTsConfig()[key];
            t!!.def = obj.def;
            t!!.defrom = obj.defrom;
            t!!.deto = obj.deto;
            t!!.appid = obj.appid;
            t!!.key = obj.key;
        }else{
            config.getTsConfig()[key] = obj;
        }
        if(obj.def) config.setDefTs(key);
    }

    fun getService(info:EditorSelectInfo):TranslateService{
        var key = config.getDefTs();
        var temp:TranslateService = BaiduTranslate(info, getTsObj(key));
        when(key){
            // "谷歌翻译"-> temp = BaiduTranslate();
        }
        return temp;
    }
}

object QsConfigFactory{
    var config = ConfigFactory();
    fun regAnAction():Array<AnAction>{
        val list: MutableList<AnAction> = ArrayList()
        var qslist = config.getQsConfig();
        for (s in qslist.keys) {
            if (!qslist[s]!!.visible) {
                continue
            }
            list.add(
                QuickSearchAction(
                    qslist[s]!!.name!!,
                    qslist[s]!!.des!!,
                    qslist[s]!!.url!!,
                    qslist[s]!!.icon!!
                )
            )
        }
        list.add(QuickSearchSetting())
        return list.toTypedArray();
    }

    fun anActionList():ArrayList<String>{
        return ArrayList(config.getQsConfig().keys);
    }

    fun anActionObjList():ArrayList<QsObj>{
        return ArrayList(config.getQsConfig().values);
    }

    fun anActionObjMap():MutableMap<String, QsObj>{
        var t = mutableMapOf<String, QsObj>();
        t.putAll(config.getQsConfig());
        return t;
    }

    fun addAnAction(name:String,des:String, url:String , icon:String){
        config.getQsConfig()[name] = QsObj(name,des,url,icon);
    }

    fun uptAnAction(name:String,des:String, url:String , icon:String){
        var obj = config.getQsConfig()[name];
        obj!!.icon = icon;
        obj!!.des = des;
        obj!!.url = url;
    }

    fun delAnAction(name:String){
        config.getQsConfig().remove(name);
    }

    fun visAnAction(name:String){
        var obj = config.getQsConfig()[name];
        obj!!.visible = !obj!!.visible;
    }
}