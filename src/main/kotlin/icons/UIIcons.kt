package icons

import com.intellij.ui.IconManager
import javax.swing.Icon

object UIIcons {
    @JvmField
    val Add: Icon = load("/icons/Add.svg")

    @JvmField
    val Remove: Icon = load("/icons/Remove.svg")



    @JvmStatic
    fun load(path: String): Icon {
        return IconManager.getInstance().getIcon(path, UIIcons::class.java)
    }
}

