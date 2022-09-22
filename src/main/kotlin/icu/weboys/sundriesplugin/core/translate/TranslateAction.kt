package icu.weboys.sundriesplugin.core.translate

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import icu.weboys.sundriesplugin.config.TsConfigFactory
import icu.weboys.sundriesplugin.util.EditorUtils


class TranslateAction :AnAction(){
    override fun actionPerformed(e: AnActionEvent) {
        EditorUtils.getEditorSelectInfoAndAccept(e){
           if(!it.value.isNullOrEmpty()) {
               TsConfigFactory.getService(it).send(it.value.replace("\r","").replace("\n","%0D%0A"));
           }
        }
    }


    override fun update(e: AnActionEvent) {
        EditorUtils.isEditorSelectTextDisplay(e);
    }
}