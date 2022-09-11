package icu.weboys.sundriesplugin.util

import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.actionSystem.CommonDataKeys
import com.intellij.openapi.editor.Editor
import icu.weboys.sundriesplugin.pobj.EditorSelectInfo
import java.awt.MouseInfo
import java.util.function.Consumer

object EditorUtils {

    // 获取编辑器
    fun getEditor(e: AnActionEvent): Editor {
       return e.getRequiredData(CommonDataKeys.EDITOR);
    }

    fun getEditorSelectText(e: AnActionEvent): String? {
        return e.getRequiredData(CommonDataKeys.EDITOR).selectionModel.selectedText;
    }

    fun getEditorSelectText(e: Editor): String? {
        return e.selectionModel.selectedText;
    }

    fun getEditorSelectTextAndAccept(e:AnActionEvent,f:Consumer<String?>){
        f.accept(getEditorSelectText(e))
    }

    fun getEditorSelectTextAndAccept(e:Editor,f:Consumer<String?>){
        f.accept(getEditorSelectText(e))
    }

    fun getEditorSelectInfoAndAccept(e:AnActionEvent, f:Consumer<EditorSelectInfo>){
        f.accept(EditorSelectInfo(getEditorSelectText(e),
            getEditor(e).selectionModel.selectionStart,getEditor(e).selectionModel.selectionEnd,MouseInfo.getPointerInfo().location,e.project,getEditor(e)))
    }
}