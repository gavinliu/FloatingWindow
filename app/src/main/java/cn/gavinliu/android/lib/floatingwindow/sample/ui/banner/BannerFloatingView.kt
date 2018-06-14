package cn.gavinliu.android.lib.floatingwindow.sample.ui.banner

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import cn.gavinliu.android.lib.floatingwindow.FloatingView
import cn.gavinliu.android.lib.floatingwindow.sample.R
import kotlinx.android.synthetic.main.fv_banner.view.*

class BannerFloatingView : FloatingView() {

    override fun onCreateView(layoutInflater: LayoutInflater, arguments: Bundle?): View =
            layoutInflater.inflate(R.layout.fv_banner, null)

    override fun onViewCreated(view: View) {
        view.hide.setOnClickListener {
            getIFloatingWindow()?.hide()
        }
    }

    override fun onDestroy() {
        // TODO
        super.onDestroy()
    }
}