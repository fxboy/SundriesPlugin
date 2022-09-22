package icu.weboys.sundriesplugin.config.ui

import com.intellij.openapi.options.SearchableConfigurable
import com.intellij.ui.components.JBPanel
import javax.swing.JComponent
import javax.swing.JPanel

class FsunConfig : SearchableConfigurable {
    override fun createComponent(): JComponent? {
        var s = JPanel();
        return s;
    }

    override fun isModified(): Boolean {
       return false
    }

    override fun apply() {
    }

    override fun getDisplayName(): String {
        return displayName;
    }

    override fun getId(): String {
        return id;
    }
}