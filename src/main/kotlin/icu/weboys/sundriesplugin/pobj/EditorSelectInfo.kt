package icu.weboys.sundriesplugin.pobj

import com.intellij.openapi.editor.Editor
import com.intellij.openapi.project.Project
import java.awt.Point

data class EditorSelectInfo(
    val value:String?,
    val offsetStart:Int = -1,
    val offsetEnd:Int = -1,
    var mouseLocation:Point = Point(-99,-99),
    val project:Project?,
    val editor:Editor,
)