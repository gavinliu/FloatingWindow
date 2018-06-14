package cn.gavinliu.android.lib.floatingwindow

import android.os.Bundle
import android.view.View

/**
 * Created by gavin on 2018/02/5.
 */
interface IFloatingWindow {

    fun show()

    fun show(bundle: Bundle?)

    fun hide()

    fun isShown(): Boolean

    fun toggle()

    fun destroy()

    fun getX(): Int

    fun getY(): Int

    fun getView(): View

    fun updateX(x: Int): IFloatingWindow

    fun updateY(y: Int): IFloatingWindow

    fun updateWidth(w: Int): IFloatingWindow

    fun updateHeight(h: Int): IFloatingWindow

    fun translationX(x: Int): IFloatingWindow

    fun translationY(y: Int): IFloatingWindow
    
}