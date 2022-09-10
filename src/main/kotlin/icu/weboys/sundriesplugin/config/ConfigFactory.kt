package icu.weboys.sundriesplugin.config

import com.intellij.openapi.actionSystem.AnAction
import icu.weboys.sundriesplugin.core.quicksearch.QuickSearchAction
import icu.weboys.sundriesplugin.core.quicksearch.QuickSearchSetting
import icu.weboys.sundriesplugin.core.quicksearch.obj.QsObj

class ConfigFactory {
    var s = PluginConfig.getInstance().state;
    fun getQsConfig():MutableMap<String, QsObj> {
       return s!!.qslist;
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