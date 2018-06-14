package cn.gavinliu.android.lib.floatingwindow

import android.content.Context
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.WindowManager

/**
 * Created by gavin on 2018/02/5.
 */
class FloatingWindow {

    companion object {

        @Volatile
        private var INSTANCE: FloatingWindow? = null

        private var DEFAULT_TAG = "default_tag"

        private fun getInstance(): FloatingWindow {
            if (INSTANCE == null) {
                synchronized(FloatingWindow::class) {
                    if (INSTANCE == null) {
                        INSTANCE = FloatingWindow()
                    }
                }
            }
            return INSTANCE as FloatingWindow
        }

        fun init(context: Context, floatingView: FloatingView): Builder {
            return Builder(context, floatingView)
        }

        fun get(): IFloatingWindow? = getInstance().mMap[DEFAULT_TAG]

        fun get(tag: String): IFloatingWindow? = getInstance().mMap[tag]

        fun clear(tag: String?) {
            getInstance().mMap.remove(tag)
        }

        fun clear(floatingWindow: IFloatingWindow) {
            var key: String? = null
            getInstance().mMap.map {
                if (it.value == floatingWindow) {
                    key = it.key
                    return@map
                }
            }
            clear(key)
        }

        fun clearAll() {
            getInstance().mMap.map {
                it.value.destroy()
            }
            getInstance().mMap.clear()
        }
    }

    private val mMap: HashMap<String, IFloatingWindow> = HashMap()


    class Builder(context: Context, view: FloatingView) {

        private var tag = DEFAULT_TAG

        internal var width = WindowManager.LayoutParams.WRAP_CONTENT
        internal var height = WindowManager.LayoutParams.WRAP_CONTENT

        internal var gravity = Gravity.TOP or Gravity.START

        internal var x = 0
        internal var y = 0

        internal var floatingView = view

        internal var windowManager: WindowManager = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager

        internal var layoutInflater: LayoutInflater = LayoutInflater.from(context)

        fun setX(x: Int): Builder {
            this.x = x
            return this
        }

        fun setY(y: Int): Builder {
            this.y = y
            return this
        }

        fun setWidth(width: Int): Builder {
            this.width = width
            return this
        }

        fun setHeight(height: Int): Builder {
            this.height = height
            return this
        }

        fun setTag(tag: String): Builder {
            this.tag = tag
            return this
        }

        fun build(): IFloatingWindow {
            val iFloatingWindow = IFloatingWindowImpl(null, this)
            getInstance().mMap[tag] = iFloatingWindow
            return iFloatingWindow
        }

        fun build(arguments: Bundle?): IFloatingWindow {
            val iFloatingWindow = IFloatingWindowImpl(arguments, this)
            getInstance().mMap[tag] = iFloatingWindow
            return iFloatingWindow
        }
    }

}