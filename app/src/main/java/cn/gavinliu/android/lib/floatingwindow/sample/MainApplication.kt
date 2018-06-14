package cn.gavinliu.android.lib.floatingwindow.sample

import android.app.Application
import android.view.WindowManager
import cn.gavinliu.android.lib.floatingwindow.FloatingWindow
import cn.gavinliu.android.lib.floatingwindow.sample.ui.banner.BannerFloatingView
import cn.gavinliu.android.lib.floatingwindow.sample.ui.move.AddFloatingView

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        FloatingWindow.init(this, BannerFloatingView())
                .setX(0)
                .setY(100)
                .setWidth(WindowManager.LayoutParams.MATCH_PARENT)
                .setHeight(400)
                .build()

        FloatingWindow.init(this, AddFloatingView())
                .setTag(AddFloatingView.TAG)
                .setX(200)
                .setY(600)
                .setWidth(resources.getDimensionPixelSize(R.dimen.move_layout_size))
                .setHeight(resources.getDimensionPixelSize(R.dimen.move_layout_size))
                .build()
    }
}