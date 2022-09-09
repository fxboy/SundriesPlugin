package icu.weboys.sundriesplugin.core.quicksearch

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import icons.UIIcons
import icu.weboys.sundriesplugin.util.EditorUtils
import icu.weboys.sundriesplugin.util.EncodeUtils
import icu.weboys.sundriesplugin.util.ProjectUtils

class QuickSearchAction(name:String,des:String,url:String,icon:String) : AnAction(name,des,UIIcons.load(icon)){
    var searchUrl = "";
    init {
        searchUrl = url;
    }
    override fun actionPerformed(e: AnActionEvent) {
       var editor =  EditorUtils.getEditor(e);
       var n =  editor.selectionModel.selectedText;
       if(!(n == null || n.trim().isEmpty())){
            n = EncodeUtils.urlEncode( n.trim().replace("\\r","").replace("\\n"," "));
            ProjectUtils.defaultBrowser(String.format(searchUrl,n));
       }
    }
}