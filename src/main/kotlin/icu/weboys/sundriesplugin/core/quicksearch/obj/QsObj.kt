package icu.weboys.sundriesplugin.core.quicksearch.obj

import java.io.Serializable

class QsObj(
    _name:String? =null,
    _des:String? =null,
    _url:String? = null,
    _icon:String? = null,
    _y:Boolean = true,
    _visible:Boolean = true,
) : Serializable
{
    var name: String? = null;
    var des:    String? = null;
    var url:    String? = null;
    var icon:   String? = null;
    var y:      Boolean = true;
    var visible:Boolean = true;

    init {
        name = _name;
        des = _des;
        url = _url;
        icon = _icon;
        y = _y;
        visible = _visible;
    }
}
