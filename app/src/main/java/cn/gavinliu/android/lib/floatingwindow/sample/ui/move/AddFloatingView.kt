package cn.gavinliu.android.lib.floatingwindow.sample.ui.move

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import cn.gavinliu.android.lib.floatingwindow.sample.R
import cn.gavinliu.android.lib.floatingwindow.view.MovableFloatingView

class AddFloatingView : MovableFloatingView() {

    override fun onCreateView(layoutInflater: LayoutInflater, arguments: Bundle?): View =
            layoutInflater.inflate(R.layout.fv_move, null)


    companion object {
       const val TAG = "ADD"
    }

}