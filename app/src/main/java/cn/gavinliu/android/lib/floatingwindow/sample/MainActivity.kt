package cn.gavinliu.android.lib.floatingwindow.sample

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import cn.gavinliu.android.lib.floatingwindow.FloatingWindow
import cn.gavinliu.android.lib.floatingwindow.sample.ui.move.AddFloatingView
import cn.gavinliu.android.lib.floatingwindow.util.FloatWindowPermissionChecker

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun jump(view: View) {
        FloatWindowPermissionChecker.tryJumpToPermissionPage(this)
    }

    fun show(view: View) {
        FloatingWindow.get()?.show()
    }

    fun showAdd(view: View) {
        FloatingWindow.get(AddFloatingView.TAG)?.show()
    }

    fun hideAdd(view: View) {
        FloatingWindow.get(AddFloatingView.TAG)?.hide()
    }

}
