package icu.weboys.sundriesplugin.core.quicksearch.window

import com.intellij.openapi.project.Project
import com.intellij.openapi.ui.DialogWrapper
import icons.UIIcons
import icu.weboys.sundriesplugin.config.PluginConfig
import icu.weboys.sundriesplugin.config.QsConfigFactory
import java.awt.Dimension
import java.awt.event.MouseAdapter
import java.awt.event.MouseEvent
import javax.swing.*


class QuickSearchSettingUI(project:Project): DialogWrapper(project) {
    private var tp: Project? = null;
    private var formPanel: JPanel? = null;
    private var scrollPane1: JScrollPane? = null;
    private var list1: JList<String>? = null;
    var actionsList:ArrayList<String> = ArrayList();
    init {
        setSize(500,400);
        isResizable = false;
        title = "新增/修改URL"
        tp = project;
        init();
    }
    override fun createCenterPanel(): JComponent? {
        formPanel = JPanel();
        formPanel!!.layout = BoxLayout(formPanel,BoxLayout.Y_AXIS);
        var panup = JPanel();
        panup!!.layout = null;
        panup!!.setBounds(0,0,100,20);
        var pandown = JPanel();
        pandown!!.layout = BoxLayout(pandown, BoxLayout.X_AXIS);
        val button1 = JButton(UIIcons.Add);
        button1.preferredSize = Dimension(30, 30);
       // button1.setLocation(0,10);
        button1.setBounds(5,10,30,30);
        val button2 = JButton(UIIcons.Remove);
        button2.preferredSize = Dimension(30, 30);
        //button2.setLocation(25,10);
        button2.setBounds(35,10,30,30);

        val button3 = JButton(UIIcons.BianjiNIco);
        button3.preferredSize = Dimension(30, 30);
        //button2.setLocation(25,10);
        button3.setBounds(65,10,30,30);

        button1.addActionListener {
            tp?.let {
                // QsConfig.searchObjList.get(0)
                if(QuickSearchSettingAddOrUpd(null,it).showAndGet()){
                    update();
                }
            };
        }

        button2.addActionListener {
            // 删除事件
            if(list1!!.selectedValue.isNotEmpty()){
                QsConfigFactory.delAnAction(list1!!.selectedValue);
                update();
            }

        }

        button3.addActionListener {
            tp?.let {
                if(list1!!.selectedValue.isNotEmpty()){
                    if(QuickSearchSettingAddOrUpd(QsConfigFactory.config.getQsConfig()!![list1!!.selectedValue],it).showAndGet()){
                        update();
                    }
                }
            };

        }
        panup!!.add(button1);
        panup!!.add(button2);
        panup!!.add(button3);
        list1 = JList();
        scrollPane1 = JScrollPane();
        update();
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
    fun update(){
        list1!!.model = object : AbstractListModel<String?>() {
            override fun getSize(): Int {
                return  QsConfigFactory.anActionList().size;
            }
            override fun getElementAt(i: Int): String {
                return QsConfigFactory.anActionList()!![i];
            }
        }
    }
}
