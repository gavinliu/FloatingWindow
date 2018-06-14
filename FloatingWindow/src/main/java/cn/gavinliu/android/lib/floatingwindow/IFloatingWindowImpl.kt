package cn.gavinliu.android.lib.floatingwindow

import android.graphics.PixelFormat
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.WindowManager

/**
 * Created by gavin on 2018/02/5.
 */
class IFloatingWindowImpl(arguments: Bundle?, builder: FloatingWindow.Builder) : IFloatingWindow {

    private var mView: View

    private var mIsShown: Boolean = false

    private var mFloatingView: FloatingView = builder.floatingView

    private var mWindowManager: WindowManager = builder.windowManager

    private var mWindowManagerLayoutParams: WindowManager.LayoutParams

    init {
        mFloatingView.setIFloatingWindow(this)

        mView = mFloatingView.onCreateView(builder.layoutInflater, arguments)
        mView.visibility = View.GONE

        mFloatingView.onViewCreated(mView)

        mIsShown = false

        mWindowManagerLayoutParams = createLayoutParams(builder)
        mWindowManager.addView(mView, mWindowManagerLayoutParams)
    }

    override fun show() {
        mIsShown = true
        mView.visibility = View.VISIBLE
        mFloatingView.onShown()
    }

    override fun show(bundle: Bundle?) {
        show()
        mFloatingView.onShown(bundle)
    }

    override fun hide() {
        mIsShown = false
        mView.visibility = View.GONE
        mFloatingView.onHide()
    }

    override fun isShown(): Boolean {
        return mIsShown
    }

    override fun toggle() {
        if (mIsShown) {
            hide()
        } else {
            show()
        }
    }

    override fun destroy() {
        mWindowManager.removeView(mView)
        mFloatingView.onDestroy()
    }

    override fun getX(): Int {
        return mWindowManagerLayoutParams.x
    }

    override fun getY(): Int {
        return mWindowManagerLayoutParams.y
    }

    override fun updateX(x: Int): IFloatingWindow {
        mWindowManagerLayoutParams.x = x
        mWindowManager.updateViewLayout(mView, mWindowManagerLayoutParams)
        return this
    }

    override fun updateY(y: Int): IFloatingWindow {
        mWindowManagerLayoutParams.y = y
        mWindowManager.updateViewLayout(mView, mWindowManagerLayoutParams)
        return this
    }

    override fun updateWidth(w: Int): IFloatingWindow {
        mWindowManagerLayoutParams.width = w
        mWindowManager.updateViewLayout(mView, mWindowManagerLayoutParams)
        return this
    }

    override fun updateHeight(h: Int): IFloatingWindow {
        mWindowManagerLayoutParams.height = h
        mWindowManager.updateViewLayout(mView, mWindowManagerLayoutParams)
        return this
    }

    override fun translationX(x: Int): IFloatingWindow {
        mWindowManagerLayoutParams.x += x
        mWindowManager.updateViewLayout(mView, mWindowManagerLayoutParams)
        return this
    }

    override fun translationY(y: Int): IFloatingWindow {
        mWindowManagerLayoutParams.y += y
        mWindowManager.updateViewLayout(mView, mWindowManagerLayoutParams)
        return this
    }

    override fun getView(): View {
        return mView
    }

    @Suppress("DEPRECATION")
    private fun createLayoutParams(builder: FloatingWindow.Builder): WindowManager.LayoutParams {
        val windowLayoutParams = WindowManager.LayoutParams()
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            windowLayoutParams.type = WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY
        } else {
            windowLayoutParams.type = WindowManager.LayoutParams.TYPE_SYSTEM_ALERT
        }
        windowLayoutParams.format = PixelFormat.RGBA_8888
        windowLayoutParams.flags = WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE
        windowLayoutParams.flags = windowLayoutParams.flags or WindowManager.LayoutParams.FLAG_FULLSCREEN
        windowLayoutParams.flags = windowLayoutParams.flags or WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        windowLayoutParams.flags = windowLayoutParams.flags or WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN
        windowLayoutParams.flags = windowLayoutParams.flags or WindowManager.LayoutParams.FLAG_WATCH_OUTSIDE_TOUCH
        windowLayoutParams.alpha = 1.0f
        windowLayoutParams.gravity = builder.gravity
        windowLayoutParams.x = builder.x
        windowLayoutParams.y = builder.y
        windowLayoutParams.width = builder.width
        windowLayoutParams.height = builder.height
        return windowLayoutParams
    }

}