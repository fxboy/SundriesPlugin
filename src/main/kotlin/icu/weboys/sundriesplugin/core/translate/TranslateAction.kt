package icu.weboys.sundriesplugin.core.translate

import com.intellij.codeInsight.hint.HintManager
import com.intellij.codeInsight.hint.QuestionAction
import com.intellij.codeInspection.ProblemsHolder
import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.editor.Editor
import com.intellij.openapi.ui.popup.JBPopupFactory
import com.intellij.ui.EditorNotificationPanel
import com.intellij.ui.EditorNotifications
import com.intellij.ui.awt.RelativePoint
import com.intellij.ui.components.JBLabel
import icons.UIIcons
import icu.weboys.sundriesplugin.config.TsConfigFactory
import icu.weboys.sundriesplugin.core.translate.window.EditorTips
import icu.weboys.sundriesplugin.pobj.EditorSelectInfo
import icu.weboys.sundriesplugin.util.EditorUtils
import java.awt.Color
import java.awt.Dimension
import java.awt.MouseInfo
import java.awt.Point
import java.util.function.Consumer
import javax.swing.JButton
import javax.swing.JPanel

class TranslateAction :AnAction(){
    override fun actionPerformed(e: AnActionEvent) {
        EditorUtils.getEditorSelectInfoAndAccept(e){
           if(!it.value.isNullOrEmpty()) {
               TsConfigFactory.getService(it).send(it.value.replace("\r","").replace("\n","%0D%0A"));
           }
        }
    }


}