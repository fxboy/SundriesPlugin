package icu.weboys.sundriesplugin.core.quicksearch

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import icons.ExternalSystemIcons
import icu.weboys.sundriesplugin.core.quicksearch.window.QuickSearchSettingUI

class QuickSearchSetting : AnAction("新增/修改URL","新增/修改当前可用搜索引擎网址", ExternalSystemIcons.Task) {
    override fun actionPerformed(e: AnActionEvent) {
        e.project?.let { QuickSearchSettingUI(it).show() };
    }
}