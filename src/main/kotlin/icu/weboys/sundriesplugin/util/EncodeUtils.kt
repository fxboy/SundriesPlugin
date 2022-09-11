package icu.weboys.sundriesplugin.util

import java.nio.charset.Charset
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException
import java.util.*


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

    fun md5x232(str: String): String? {
        var reStr: String? = null
        try {
            val md5 = MessageDigest.getInstance("MD5")
            val bytes = md5.digest(str.toByteArray())
            val stringBuffer = StringBuffer()
            for (b in bytes) {
                val bt = b.toInt() and 0xff
                if (bt < 16) {
                    stringBuffer.append(0)
                }
                stringBuffer.append(Integer.toHexString(bt))
            }
            reStr = stringBuffer.toString()
        } catch (e: NoSuchAlgorithmException) {
            e.printStackTrace()
        }
        return reStr
    }
}