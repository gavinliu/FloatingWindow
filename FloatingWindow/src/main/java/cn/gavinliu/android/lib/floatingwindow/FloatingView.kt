package cn.gavinliu.android.lib.floatingwindow

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View

/**
 * Created by gavin on 2018/02/5.
 */
abstract class FloatingView {

    private var mIFloatingWindow: IFloatingWindow? = null


    internal fun setIFloatingWindow(floatingView: IFloatingWindow) {
        mIFloatingWindow = floatingView
    }

    fun getIFloatingWindow(): IFloatingWindow? {
        return mIFloatingWindow
    }

    abstract fun onCreateView(layoutInflater: LayoutInflater, arguments: Bundle?): View

    abstract fun onViewCreated(view: View)

    open fun onShown() {

    }

    open fun onShown(bundle: Bundle?) {

    }

    open fun onHide() {

    }

    open fun onDestroy() {

    }

}