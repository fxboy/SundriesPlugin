package icu.weboys.sundriesplugin.core.quicksearch.config

import java.util.*

object QsConfig {
    var default = "https://www.baidu.com/s?wd=%s";
    var searchObjList = Arrays.asList(
        SearchObj("百度搜索","百度一下,你就知道",default,null),
        SearchObj("程序员搜索","https://kaifa.baidu.com/","https://kaifa.baidu.com/searchPage?wd=%s",null),
        SearchObj("谷歌搜索","https://www.google.com/","https://www.google.com/search?q=%s&ie=UTF-8",null),
        SearchObj("CSDN博客搜索","成就一亿技术人","https://so.csdn.net/so/search?q=%s",null),
        SearchObj("Stackoverflow","https://stackoverflow.com","https://stackoverflow.com/search?q=%s",null),
    );
}