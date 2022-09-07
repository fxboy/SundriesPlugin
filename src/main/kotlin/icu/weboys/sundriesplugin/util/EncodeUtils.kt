package icu.weboys.sundriesplugin.util

object EncodeUtils {
    fun urlEncode(str:String):String{
        return java.net.URLEncoder.encode(str,"utf-8");
    }
    fun urlEncode(str:String,enc:String):String{
        return java.net.URLEncoder.encode(str,enc);
    }
    fun urlDecode(str:String):String{
        return java.net.URLDecoder.decode(str,"utf-8");
    }
    fun urlDecode(str:String,enc:String):String{
        return java.net.URLDecoder.decode(str,enc);
    }
}