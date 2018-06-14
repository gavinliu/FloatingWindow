package cn.gavinliu.android.lib.floatingwindow.util

import android.content.Context
import android.widget.Toast
import ezy.assist.compat.SettingsCompat

object FloatWindowPermissionChecker {

    fun check(context: Context): Boolean {
        return SettingsCompat.canDrawOverlays(context.applicationContext)
    }

    fun tryJumpToPermissionPage(context: Context) {
        try {
            SettingsCompat.manageDrawOverlays(context.applicationContext)
        } catch (e: Exception) {
            showAlertToast(context.applicationContext)
        }
    }

    private fun showAlertToast(context: Context) {
        Toast.makeText(context.applicationContext, "无法跳转至权限设置页面，请手动设置或向我们反馈"
                , Toast.LENGTH_LONG).show()
    }

}