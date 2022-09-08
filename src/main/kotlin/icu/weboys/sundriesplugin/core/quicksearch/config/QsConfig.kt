package icu.weboys.sundriesplugin.core.quicksearch.config

import icons.UIIcons
import java.util.*
import javax.swing.Icon
import kotlin.collections.HashMap

// 待改动
// 从配置中读取的数据先放入map中，然后 list 用map的values集
object QsConfig {
    // 默认引擎链接
    var default = "https://www.baidu.com/s?wd=%s";
    // 哈希表存储对应的搜索
    var searchObjMap:Map<String,SearchObj> = HashMap();

    // 临时写法
    var searchObjList = Arrays.asList(
        SearchObj("百度搜索","百度一下,你就知道",default,UIIcons.BaiduIco,false),
        SearchObj("程序员搜索","https://kaifa.baidu.com/","https://kaifa.baidu.com/searchPage?wd=%s",UIIcons.yuanIco,false),
        SearchObj("谷歌搜索","https://www.google.com/","https://www.google.com/search?q=%s&ie=UTF-8",UIIcons.GoogleIco,false),
        SearchObj("CSDN博客搜索","成就一亿技术人","https://so.csdn.net/so/search?q=%s",UIIcons.CsdnIco,false),
        SearchObj("Stackoverflow","https://stackoverflow.com","https://stackoverflow.com/search?q=%s",UIIcons.StackoverflowIco,false),
    );
    init {
        // 初始化
        // 从配置中读取数据
        // 放入List内
        // 放入哈希表内
    }

    // 删除
    fun remove(_name: String){

    }

    // 修改引擎内容
    fun update(_oldName:String,_name:String, _des:String, _url:String, _icon: Icon?){

    }

    // 插入新的搜索引擎
    fun insert(_name:String, _des:String, _url:String, _icon: Icon?):Map<Boolean,String>{
        if(searchObjMap.containsKey(_name)){
            return mapOf(Pair(false,"已存在相同名称的搜索引擎"));
        }
        var item = SearchObj(_name,_des,_url,_icon,true);
        searchObjList.add(item);
        searchObjMap += Pair(_name,item)
        save();
        return mapOf(Pair(true,String.format("%s 添加成功",_name)));
    }

    fun save(){
        // 将数据存入配置中....
    }
}