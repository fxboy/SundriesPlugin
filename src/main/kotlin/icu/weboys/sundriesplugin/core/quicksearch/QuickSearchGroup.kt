package icu.weboys.sundriesplugin.core.quicksearch

import com.intellij.openapi.actionSystem.ActionGroup
import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import icu.weboys.sundriesplugin.config.QsConfigFactory

class QuickSearchGroup : ActionGroup() {
    override fun getChildren(e: AnActionEvent?): Array<AnAction> {
        return QsConfigFactory.regAnAction();
    }
}

