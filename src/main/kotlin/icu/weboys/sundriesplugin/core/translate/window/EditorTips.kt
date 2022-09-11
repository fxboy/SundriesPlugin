package icu.weboys.sundriesplugin.core.translate.window

import com.intellij.notification.NotificationGroupManager
import com.intellij.notification.NotificationType
import com.intellij.openapi.application.ApplicationManager
import com.intellij.openapi.command.WriteCommandAction
import com.intellij.openapi.editor.Editor
import com.intellij.openapi.project.Project
import com.intellij.openapi.ui.popup.JBPopupFactory
import com.intellij.psi.PsiDocumentManager
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.ui.awt.RelativePoint
import com.intellij.ui.components.JBLabel
import com.intellij.ui.components.JBTextArea
import icu.weboys.sundriesplugin.pobj.EditorSelectInfo
import java.awt.*
import java.awt.datatransfer.StringSelection
import java.awt.event.MouseAdapter
import java.awt.event.MouseEvent
import javax.swing.*


class EditorTips(_ei: EditorSelectInfo, _t:String) {
    lateinit var ei:EditorSelectInfo;
    lateinit var t:String;
    init {
        ei = _ei
        t = _t;
    }

    fun init(j:JPanel) {
        var ins = JBPopupFactory.getInstance();
//        var text = JBTextArea(c);
//
//        var top = JPanel();
//
//
//        var panel = JPanel();
//        var sp = JScrollPane();
////        text.
//        text.wrapStyleWord = true;
//        text.lineWrap = true;
//        panel.layout =  BoxLayout(panel,BoxLayout.PAGE_AXIS);
//        panel.add(text);
//        panel.autoscrolls = true;
       // text.isEditable = false;
        ins.createComponentPopupBuilder(j, JBLabel())//参数说明：内容对象,优先获取
            .setRequestFocus(true)
            .setTitle(t)
            .setMovable(true)
            .setResizable(false)
            .setNormalWindowLevel(false)
            .createPopup()
            .show( RelativePoint(Point(ei.mouseLocation.x,ei.mouseLocation.y + 10)))
            //.showCenteredInCurrentWindow(p)



    }


    fun get(c:String){
        var main = JPanel()
        var panel1 = JPanel()
        var label1 = JBLabel("复制翻译内容")
        var label2 = JBLabel("替换选中内容")
        var label3 = JBLabel("打开翻译窗口")
        var panel2 = JPanel()
        var textArea1 = JBTextArea()
        var scrollPane1 = JScrollPane()

        label1.addMouseListener(object : MouseAdapter() {
            override fun mouseClicked(me: MouseEvent) {
                 Toolkit.getDefaultToolkit().systemClipboard.setContents(StringSelection(textArea1.text),null)
                NotificationGroupManager.getInstance()
                    .getNotificationGroup("ts.notice")
                    .createNotification("翻译内容已复制", NotificationType.INFORMATION)
                    .notify(ei.project);
            }
        })

        label2.addMouseListener(object : MouseAdapter() {
            override fun mouseClicked(me: MouseEvent) {
                WriteCommandAction.runWriteCommandAction(ei.project){
                    ei.editor.document.replaceString(ei.editor.selectionModel.selectionStart,ei.editor.selectionModel.selectionEnd,textArea1.text);
                }
            }
        })
        // 设置man的布局为  2行1列
        main.layout = null;
        main.preferredSize = Dimension(300, 128)
        // 设置panel1的布局为 1行2列
        panel1.layout = FlowLayout(FlowLayout.LEADING,5,0)
        panel1.preferredSize = Dimension(300, 15)
        panel1.setBounds(5,110,295,20)
        panel1.add(label1)
        panel1.add(label2)
        panel1.add(label3)
        //panel1.add(label3)
        panel2.setBounds(5,5,295,90)
        panel2.layout = GridLayout(1,1);
        //panel2.preferredSize = Dimension(600, 170)
        panel2.autoscrolls = true
        panel2.layout =   BoxLayout(panel2,BoxLayout.Y_AXIS);
        scrollPane1.border = null
        textArea1.text = c.replace("%0D%0A","\n")
        textArea1.wrapStyleWord = true
        textArea1.lineWrap = true
        textArea1.border = null
        textArea1.isEditable = false
        textArea1.isDoubleBuffered = true
        textArea1.background = panel1.background
        scrollPane1.autoscrolls = true
        scrollPane1.setViewportView(textArea1)
        panel2.add(scrollPane1)
        main.add(panel2);
        main.add(panel1)
        init(main);
    }
}