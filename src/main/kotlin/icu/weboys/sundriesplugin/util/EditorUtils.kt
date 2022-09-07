package icu.weboys.sundriesplugin.util

import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.actionSystem.CommonDataKeys
import com.intellij.openapi.editor.Editor

object EditorUtils {

    // 获取编辑器
    fun getEditor(e: AnActionEvent): Editor {
       return e.getRequiredData(CommonDataKeys.EDITOR);
    }
}