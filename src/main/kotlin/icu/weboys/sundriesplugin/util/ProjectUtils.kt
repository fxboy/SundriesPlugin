package icu.weboys.sundriesplugin.util

import java.awt.Desktop
import java.net.URI

object ProjectUtils {
    fun defaultBrowser(url:String){
        Desktop.getDesktop().browse(URI.create(url));
    }

    fun defaultBrowser(uri:URI){
        Desktop.getDesktop().browse(uri);
    }
}