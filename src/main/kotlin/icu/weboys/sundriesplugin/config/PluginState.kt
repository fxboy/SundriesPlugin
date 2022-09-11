package icu.weboys.sundriesplugin.config

import icons.ICON
import icu.weboys.sundriesplugin.core.quicksearch.obj.QsObj
import icu.weboys.sundriesplugin.core.translate.obj.TsObj

data class PluginState (
    var version:String = "",
    var qslist: MutableMap<String, QsObj> = mutableMapOf<String,QsObj>(
        "百度搜索" to QsObj("百度搜索","百度一下,你就知道","https://www.baidu.com/s?wd=%s",ICON.BaiduIco),
        "开发者搜索" to QsObj("开发者搜索","百度开发者搜索引擎","https://kaifa.baidu.com/searchPage?wd=%s",ICON.BaiduIco),
        "Google" to QsObj("Google","https://www.google.com/","https://www.google.com/search?q=%s&ie=UTF-8",ICON.GoogleIco),
        "CSDN" to QsObj("CSDN","成就一亿技术人的技术社区","https://so.csdn.net/so/search?q=%s",ICON.CsdnIco),
        "Stackoverflow" to QsObj("Stackoverflow","全球最大的技术问答网站","https://stackoverflow.com/search?q=%s",ICON.StackoverflowIco),
        "Bing" to QsObj("Bing","https://cn.bing.com/","https://cn.bing.com/search?q=%s",ICON.Bing),
    ),
    var tslist:MutableMap<String,TsObj> = mutableMapOf<String,TsObj>(
        "百度翻译" to TsObj(),
        "谷歌翻译" to TsObj()
    ),
    var defTranslate:String = "百度翻译"
)