package icu.weboys.sundriesplugin.core.quicksearch.window

import com.intellij.openapi.fileChooser.FileChooser
import com.intellij.openapi.fileChooser.FileChooserDescriptor
import com.intellij.openapi.project.Project
import com.intellij.openapi.ui.DialogPanel
import com.intellij.openapi.ui.DialogWrapper
import icons.ICON
import icons.UIIcons
import icu.weboys.sundriesplugin.config.QuickSearchConfig
import icu.weboys.sundriesplugin.obj.QS
import java.awt.event.ActionListener
import javax.swing.*


class QuickSearchSettingAddOrUpd(_obj: QS?,project: Project): DialogWrapper(project)  {
    val fileChooserDescriptor = FileChooserDescriptor(true, false, true, true, false, false)
    var obj: QS? = null;
    var upt = false;
    var pjt: Project? = null;
    var txt1 = "";
    var txt2 = "输入网址(用 '%s' 来代替搜索词)";
    var txt3 = "";
    var icon: String? = ICON.defaultSearchIco;

    var t:JTextField? = null;
    var t1:JTextField? = null ;
    var t2:JTextField? = null ;

    private var formPanel: DialogPanel? = null;
    init {
        obj = _obj;
        pjt = project;
        title = "添加自定义网址";
        if(obj != null) {
            title = String.format("正在修改 %s", obj!!.name);
            upt = true;
        }
        setSize(420,228);
        isResizable = false;
        init();
    }
    override fun createCenterPanel(): JComponent? {
        create();
        return formPanel;
    }
    // 添加
    fun create() {
        if (obj != null) {
            txt1 = obj!!.name;
            txt2 = obj!!.url;
            txt3 = obj!!.des;
            icon = obj!!.icon;
        }
        formPanel = DialogPanel();
        formPanel!!.layout = null;
        var u = JPanel();//第一个JPanel
        u.setBounds(0, 5, 360, 30);
        u.layout = BoxLayout(u, BoxLayout.X_AXIS);
        var s = JPanel();//第一个JPanel
        s.setBounds(0, 45, 360, 30);
        s.layout = BoxLayout(s, BoxLayout.X_AXIS);
        var b = JPanel();//第一个JPanel
        b.setBounds(0, 90, 360, 30);
        b.layout = BoxLayout(b, BoxLayout.X_AXIS);
        var lab = JLabel("名称：");
        t = JTextField(txt1);

        t!!.isEnabled = !upt;

        u.add(lab);
        u.add(t);
        var bt = JButton(icon?.let { UIIcons.load(it) });
        bt.setSize(25, 25);
        u.add(bt);
        var lab1 = JLabel("网址：");
        t1 = JTextField(txt2);
        s.add(lab1);
        s.add(t1);

        var lab2 = JLabel("简介：");
        t2 = JTextField(txt3);
        b.add(lab2);
        b.add(t2);
        formPanel!!.add(u);
        formPanel!!.add(s);
        formPanel!!.add(b);


        val listener = ActionListener {
            println(it.actionCommand)
            var temp = FileChooser.chooseFiles(fileChooserDescriptor, pjt, null);
            if(temp.isNotEmpty()){
                icon = temp[0].path;
//                bt.icon =;
                (it.source as JButton).icon = UIIcons.load("[file]" + icon!!)
            }
        }

        // 添加choose图标事件
        bt.addActionListener(listener);
    }
    override fun doOKAction() {
        var l = if(upt) QuickSearchConfig.getInstance()!!.upt(t!!.text,t2!!.text,t1!!.text,icon) else QuickSearchConfig.getInstance()!!.add(t!!.text,t2!!.text,t1!!.text,icon);

        if(l.isNotEmpty()){
            QuickSearchConfig.getInstance()!!.settingJson = l;
        }else{
            // 通知失败
        }
        super.doOKAction()
    }
}


