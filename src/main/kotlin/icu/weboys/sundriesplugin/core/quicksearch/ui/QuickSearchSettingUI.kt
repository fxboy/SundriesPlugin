package icu.weboys.sundriesplugin.core.quicksearch.ui

import com.intellij.openapi.project.Project
import com.intellij.openapi.ui.DialogWrapper
import icons.UIIcons
import java.awt.Dimension
import javax.swing.JButton
import javax.swing.JComponent
import javax.swing.JPanel


class QuickSearchSettingUI(project:Project): DialogWrapper(project) {
    private var formPanel: JPanel? = null;
    init {
        setSize(500,400);
        isResizable = false;
        title = "快捷搜索配置"
        init();
    }
    override fun createCenterPanel(): JComponent? {
        formPanel = JPanel();
        val button1 = JButton(UIIcons.Add);
        button1.preferredSize = Dimension(30, 30);
       // button1.setLocation(0,10);
        button1.setBounds(5,10,30,30);
        val button2 = JButton(UIIcons.Remove);
        button2.preferredSize = Dimension(30, 30);
        //button2.setLocation(25,10);
        button2.setBounds(30,10,30,30);
        formPanel!!.add(button1);
        formPanel!!.add(button2);
        return formPanel;
    }
}


