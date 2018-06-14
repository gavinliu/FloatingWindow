# FloatingWindow

Easy to use floating window library, just like fragment. You can build large floating window applications

## Overview

### FloatingView

FloatingView has a similar lifecycle as fragment.

```kotlin
abstract class FloatingView {
    private var mIFloatingWindow: IFloatingWindow? = null

    abstract fun onCreateView(layoutInflater: LayoutInflater, arguments: Bundle?): View

    abstract fun onViewCreated(view: View)

    open fun onShown() { }

    open fun onHide() { }

    open fun onDestroy() { }
}

```

### IFloatingWindow

IFloatingWindow is FloatingView control handle class

```kotlin
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
```

### FloatingWindow

FloatingWindow is a multi-IFloatingWindow management class

```kotlin
class FloatingWindow {
    private val mMap: HashMap<String, IFloatingWindow> = HashMap()

    fun get(tag: String): IFloatingWindow? = getInstance().mMap[tag]

    fun clear(tag: String?) {
        getInstance().mMap.remove(tag)
    }
}
```


## Usage

### Impl FloatingView

```kotlin
class BannerFloatingView : FloatingView() {

    override fun onCreateView(layoutInflater: LayoutInflater, arguments: Bundle?): View =
            layoutInflater.inflate(R.layout.fv_banner, null)

    override fun onViewCreated(view: View) {
        view.hide.setOnClickListener {
            getIFloatingWindow()?.hide()
        }
    }

    override fun onShown() {
        super.onShown()
        // TODO
    }

    override fun onHide() {
        super.onHide()
        // TODO
    }

    override fun onDestroy() {
        super.onDestroy()
        // TODO
    }
}
```

### Create FloatingWindow

```kotlin
FloatingWindow.init(this, BannerFloatingView())
    .setX(0)
    .setY(100)
    .setWidth(WindowManager.LayoutParams.MATCH_PARENT)
    .setHeight(400)
    .build()
```

### Show

```kotlin
FloatingWindow.get()?.show()
```

### Hide

```kotlin
FloatingWindow.get()?.hide()
```

## License

Apache License Version 2.0

Copyright (c) 2018-present, GavinLiu