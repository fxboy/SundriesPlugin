package icu.weboys.sundriesplugin.core.quicksearch

import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.actionSystem.ActionGroup
import com.intellij.openapi.actionSystem.AnAction
import icu.weboys.sundriesplugin.core.quicksearch.config.QsConfig
import icu.weboys.sundriesplugin.core.quicksearch.config.SearchObj
import java.util.Arrays

class QuickSearchGroup : ActionGroup() {
    override fun getChildren(e: AnActionEvent?): Array<AnAction> {
        var actionsList:ArrayList<AnAction> = ArrayList();
        for(k in QsConfig.searchObjList){
            actionsList.add(QuickSearchAction(k.name,k.des,k.url,k.icon));
        }
        actionsList.add(QuickSearchSetting());
        return actionsList.toTypedArray();
    }
}

