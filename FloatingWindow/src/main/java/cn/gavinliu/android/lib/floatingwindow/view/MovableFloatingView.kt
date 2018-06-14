package cn.gavinliu.android.lib.floatingwindow.view

import android.view.MotionEvent
import android.view.View
import cn.gavinliu.android.lib.floatingwindow.FloatingView

abstract class MovableFloatingView : FloatingView() {

    private val moveOffset = 8

    private var lastX = 0F
    private var lastY = 0F

    private var isMoveMode = false

    override fun onViewCreated(view: View) {

        view.setOnTouchListener { v, event ->
            when (event.action) {
                MotionEvent.ACTION_DOWN -> {
                    lastX = event.rawX
                    lastY = event.rawY
                    isMoveMode = false
                }

                MotionEvent.ACTION_MOVE -> {
                    val deltaX = event.rawX - lastX
                    val deltaY = event.rawY - lastY

                    if (Math.abs(deltaX) > moveOffset || Math.abs(deltaY) > moveOffset) {
                        isMoveMode = true
                    }

                    if (isMoveMode) {
                        getIFloatingWindow()?.translationX(deltaX.toInt())
                        getIFloatingWindow()?.translationY(deltaY.toInt())
                    }

                    lastX = event.rawX
                    lastY = event.rawY
                }

                MotionEvent.ACTION_UP -> {
                    view.requestFocus()
                }
            }
            isMoveMode
        }
    }
}