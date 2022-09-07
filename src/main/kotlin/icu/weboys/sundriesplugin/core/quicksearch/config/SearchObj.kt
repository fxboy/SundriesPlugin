package icu.weboys.sundriesplugin.core.quicksearch.config

import javax.swing.Icon


class SearchObj(_name:String, _des:String, _url:String, _icon: Icon?){
    var name:String = "";
    var des:String = "";
    var url:String = "";
    var icon: javax.swing.Icon? = null;
    init {
        name = _name;
        des = _des;
        url = _url;
        icon = _icon;
    }
}
