package icu.weboys.sundriesplugin.util

import io.netty.handler.codec.base64.Base64Encoder
import java.nio.charset.Charset
import java.util.Base64

object EncodeUtils {
    fun urlEncode(str:String):String{
       return java.net.URLEncoder.encode(str,"utf-8").replace("+", "%20");
    }
    fun urlEncode(str:String,enc:String):String{
        return java.net.URLEncoder.encode(str,enc).replace("+", "%20");
    }
    fun urlDecode(str:String):String{
        return java.net.URLDecoder.decode(str,"utf-8");
    }
    fun urlDecode(str:String,enc:String):String{
        return java.net.URLDecoder.decode(str,enc);
    }

    fun base64Encode(x:String):String{
        return String(Base64.getEncoder().encode(x.toByteArray()), Charset.forName("utf-8"));
    }

    fun base64Decode(x:String):String{
        return String(Base64.getDecoder().decode(x),Charset.forName("utf-8"));
    }
}