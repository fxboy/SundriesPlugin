package icu.weboys.sundriesplugin.core.translate.obj

import icu.weboys.sundriesplugin.core.translate.enu.LangType

class TsObj (_appid:String = "",_key:String = "",_defrom:String = "auto",_deto:String = "zh",_def:Boolean = false){
    lateinit var appid:String
    lateinit var key:String
    lateinit var defrom:String
    lateinit var deto:String
    var def:Boolean = false

    init {
        appid = _appid
        key = _key
        defrom = _defrom
        deto = _deto
        def = _def
    }
}