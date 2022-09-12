package icons

import com.intellij.ui.IconManager
import java.io.File
import java.net.URL
import javax.swing.Icon
import javax.swing.ImageIcon

object UIIcons {
    @JvmField
    val Add: Icon = load("/icons/Add.svg")

    @JvmField
    val Remove: Icon = load("/icons/Remove.svg")

    @JvmField
    val BaiduIco:Icon = load("/icons/baidu.svg")

    @JvmField
    val GoogleIco:Icon = load("/icons/Google.svg")

    @JvmField
    val CsdnIco:Icon = load("/icons/csdn.svg")

    @JvmField
    val StackoverflowIco:Icon = load("/icons/stackoverflow.svg")

    @JvmField
    val yuanIco:Icon = load("/icons/yuan.svg")

    @JvmField
    val defaultSearchIco:Icon = load("/icons/default-search.svg")

    @JvmField
    val BianjiIco:Icon = load("/icons/bianji_o.svg")
    @JvmField
    val BianjiNIco:Icon = load("/icons/bianji_n.svg")


    @JvmStatic
    fun load(path: String): Icon {
       if(!path.startsWith("/icons") && !path.endsWith(".svg")){
           return loadForPath(path);
       } else{
           return IconManager.getInstance().getIcon(path, UIIcons::class.java);
       }
    }
    @JvmStatic
    fun loadForPath(path: String): Icon {
        val imgURL: URL = File(path).toURI().toURL()
        var ft = ImageIcon(imgURL);
        // 大小超过 16*16 或未读取到 使用默认的图标

        if((ft.iconHeight > 16 || ft.iconWidth > 16)){
            return defaultSearchIco;
        }

        return ft;
    }

}

