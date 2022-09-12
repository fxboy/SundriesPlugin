package icu.weboys.sundriesplugin.core.translate

import com.alibaba.fastjson.JSON
import com.intellij.codeInsight.hint.HintManager
import com.intellij.notification.NotificationGroupManager
import com.intellij.notification.NotificationType
import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.application.ApplicationManager
import com.intellij.openapi.editor.Editor
import com.intellij.openapi.progress.ProgressIndicator
import com.intellij.openapi.progress.ProgressManager
import com.intellij.openapi.progress.Task
import com.intellij.openapi.project.Project
import icu.weboys.sundriesplugin.core.translate.obj.TsObj
import icu.weboys.sundriesplugin.core.translate.window.EditorTips
import icu.weboys.sundriesplugin.pobj.EditorSelectInfo
import icu.weboys.sundriesplugin.util.EditorUtils
import icu.weboys.sundriesplugin.util.EncodeUtils
import okhttp3.*
import org.jetbrains.annotations.NotNull
import java.awt.EventQueue
import java.io.IOException
import javax.swing.JLabel
import javax.swing.JPanel


abstract class TranslateService(_info: EditorSelectInfo, _obj:TsObj){
    // 临时写入
    var appid = "";
    // 临时写入
    var key = "";

    var api = "https://fanyi-api.baidu.com/api/trans/vip/translate";


    lateinit var project:Project;

    lateinit var setting:TsObj;
    lateinit var editor:Editor;
    lateinit var info:EditorSelectInfo;

    init {
        setting = _obj;
        info = _info;
        project = _info.project!!;
        editor = _info.editor;
        appid = setting.appid
        key = setting.key



    }

    // 百度通用翻译
    private fun createApi(q:String,from:String,to:String):FormBody{
        var salt = System.currentTimeMillis().toString();
        val formBody = FormBody.Builder().add("q",q)
            .add("from",from)
            .add("to",to)
            .add("appid",appid)
            .add("salt",salt)
            .add("sign",createSign(q,salt))
            .build()
        return formBody;
    }
    private fun createSign(q:String, s:String):String{
        return EncodeUtils.md5x232(String.format("%s%s%s%s",appid,q,s,key))!!;
    }
    fun send( params :FormBody){
                ProgressManager.getInstance().run(object : Task.Backgroundable(project, "FSundries Translate") {
                    override fun run(@NotNull progressIndicator: ProgressIndicator) {
                        progressIndicator.isIndeterminate = false;
                        val request = Request.Builder()
                            .url(api)
                            .post(params)
                            .addHeader("Content-Type","application/x-www-form-urlencoded; charset=utf-8")
                            .build()

                        try{
                            client.newCall(request).execute().use { response ->
                                if (!response.isSuccessful) throw IOException("Unexpected code $response")
                                var s = response.body!!.string()
                                ui(s);
                            }
                        }catch (e:Exception){
                            NotificationGroupManager.getInstance()
                                .getNotificationGroup("ts.error")
                                .createNotification(e.message!!, NotificationType.ERROR)
                                .notify(project);
                        }
                    }
                })
    }

    fun send( q:String,from:String,to:String){
        return send(createApi(q,from,to));
    }

    fun send(q:String){
        return send(q,setting.defrom,setting.deto);
    }


    private val client = OkHttpClient()

    fun ui(json:String){
        if(json.isNullOrEmpty()) return;
        // 解析json
        var jo = JSON.parseObject(json);
        if(jo.containsKey("error_code") && jo.containsKey("error_msg")){
            NotificationGroupManager.getInstance()
                .getNotificationGroup("ts.error")
                .createNotification(jo.getString("error_msg"), NotificationType.ERROR)
                .notify(project);
        }else{
            EventQueue.invokeLater(
                Runnable {
                    ApplicationManager.getApplication().runReadAction {
                        var res = jo.getJSONArray("trans_result").getJSONObject(0).getString("dst");
                         EditorTips(info,"").get(res);
                    }
                }
            )
        }


    }



}