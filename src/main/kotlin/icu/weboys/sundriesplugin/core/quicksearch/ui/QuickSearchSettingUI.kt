package icu.weboys.sundriesplugin.core.quicksearch.ui

import com.intellij.openapi.project.Project
import com.intellij.openapi.ui.DialogWrapper
import icons.UIIcons
import icu.weboys.sundriesplugin.core.quicksearch.config.QsConfig
import java.awt.Dimension
import java.awt.event.MouseAdapter
import java.awt.event.MouseEvent
import javax.swing.*


class QuickSearchSettingUI(project:Project): DialogWrapper(project) {
    private var formPanel: JPanel? = null;
    private var scrollPane1: JScrollPane? = null
    private var list1: JList<String>? = null
    init {
        setSize(500,400);
        isResizable = false;
        title = "快捷搜索配置"
        init();
    }
    override fun createCenterPanel(): JComponent? {
        formPanel = JPanel();
        formPanel!!.layout = BoxLayout(formPanel,BoxLayout.Y_AXIS);
        var panup = JPanel();
        panup!!.layout = BoxLayout(panup, BoxLayout.X_AXIS);
        panup!!.setBounds(0,0,100,30);
        var pandown = JPanel();
        pandown!!.layout = BoxLayout(pandown, BoxLayout.X_AXIS);
        val button1 = JButton(UIIcons.Add);
        button1.preferredSize = Dimension(30, 30);
       // button1.setLocation(0,10);
        button1.setBounds(5,10,30,30);
        val button2 = JButton(UIIcons.Remove);
        button2.preferredSize = Dimension(30, 30);
        //button2.setLocation(25,10);
        button2.setBounds(30,10,30,30);
        panup!!.add(button1);
        panup!!.add(button2);
        var actionsList:ArrayList<String> = ArrayList();
        for(k in QsConfig.searchObjList){
            actionsList.add(k.name);
        }
        list1 = JList();
        scrollPane1 = JScrollPane();
        //---- list1 ----
        list1!!.setModel(object : AbstractListModel<String?>() {
            override fun getSize(): Int {
                return actionsList.size
            }

            override fun getElementAt(i: Int): String {
                return actionsList.get(i)
            }
        })
        list1!!.addMouseListener(object : MouseAdapter() {
            override fun mouseClicked(e: MouseEvent) {

            }
        })
        scrollPane1!!.setViewportView(list1)
        //scrollPane1!!.setBounds(5,30,100,100);
        pandown!!.add(scrollPane1);
        formPanel!!.add(panup);
        formPanel!!.add(pandown);
        return formPanel;
    }
}
