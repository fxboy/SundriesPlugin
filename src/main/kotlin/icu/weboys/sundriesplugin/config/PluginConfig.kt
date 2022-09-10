package icu.weboys.sundriesplugin.config

import com.intellij.openapi.application.ApplicationManager
import com.intellij.openapi.components.PersistentStateComponent
import com.intellij.openapi.components.RoamingType
import com.intellij.openapi.components.State
import com.intellij.openapi.components.Storage

@State(name = "SundriesConfig",storages = [Storage(value = "sundries-config.xml", roamingType = RoamingType.DISABLED)])
class PluginConfig : PersistentStateComponent<PluginState> {
    private var pluginState= PluginState()
    override fun getState(): PluginState? {
        return pluginState;
    }
    override fun loadState(state: PluginState) {
        pluginState = state;
    }
    companion object {
        @JvmStatic
        fun getInstance(): PersistentStateComponent<PluginState> {
            return ApplicationManager.getApplication().getService(PluginConfig::class.java)
        }
    }

}