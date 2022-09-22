package icu.weboys.sundriesplugin.core.translate.ui

import com.intellij.openapi.options.SearchableConfigurable
import java.awt.*
import javax.swing.*

class TsConfig  : SearchableConfigurable {
    override fun createComponent(): JComponent? {
        return TsConfigPanel();
    }

    override fun isModified(): Boolean {
        return true
    }

    override fun apply() {
    }

    override fun getDisplayName(): String {
        return displayName;
    }

    override fun getId(): String {
        return id;
    }

    // 重置
    override fun reset(){

    }

    // 触发保存
    fun save(){

    }





}


class TsConfigPanel :JPanel(){
    init {
        initComponents();
    }

    private fun initComponents() {
        layout = null;

        // 常用配置
        var j = JPanel();

        // api配置
        var j1 = JPanel();

        //
        var j2 = JPanel();

    }

}