package icu.weboys.sundriesplugin.core.quicksearch.ui

import com.intellij.openapi.project.Project
import com.intellij.openapi.ui.DialogWrapper
import javax.swing.JComponent
import javax.swing.JPanel

class QuickSearchSettingUI(project:Project): DialogWrapper(project) {
    private val formPanel: JPanel? = null;
    init {
        setSize(500,400);
        isResizable = false;
        title = "快捷搜索配置"
        init();
    }

    override fun createCenterPanel(): JComponent? {
        return formPanel;
    }
}


