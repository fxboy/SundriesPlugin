package icons

import com.intellij.ui.IconManager
import javax.swing.Icon

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


    @JvmStatic
    fun load(path: String): Icon {
        return IconManager.getInstance().getIcon(path, UIIcons::class.java)
    }
}

