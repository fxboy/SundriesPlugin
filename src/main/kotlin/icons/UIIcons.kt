package icons

import com.intellij.ui.IconManager
import javax.swing.Icon
import javax.swing.ImageIcon
import javax.swing.plaf.IconUIResource

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
       if(path.startsWith("[file]")){
           return loadForPath(path);
       } else{
           return IconManager.getInstance().getIcon(path, UIIcons::class.java);
       }
    }

    @JvmStatic
    fun loadForPath(path: String): Icon {
        return ImageIcon(path.replace("[file]",""))
    }

}

