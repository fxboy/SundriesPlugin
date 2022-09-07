package icu.weboys.sundriesplugin.core.quicksearch

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.actionSystem.LangDataKeys
import com.intellij.psi.PsiDirectory
import icons.ExternalSystemIcons
import icu.weboys.sundriesplugin.core.quicksearch.ui.QuickSearchSettingUI

class QuickSearchSetting : AnAction("Setting","系统设置啊", ExternalSystemIcons.Task) {
    override fun actionPerformed(e: AnActionEvent) {
        e.project?.let { QuickSearchSettingUI(it).show() };
    }
}