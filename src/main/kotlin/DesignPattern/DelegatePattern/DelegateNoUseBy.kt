package DesignPattern.DelegatePattern

// https://codechacha.com/ko/kotlin-deligation-using-by/


interface IWindow {
    fun getWidth() : Int
    fun getHeight() : Int
}

open class TransparentWindow() : IWindow {
    override fun getWidth(): Int {
        return 100
    }

    override fun getHeight() : Int{
        return 150
    }
}

class UI(window: IWindow) : IWindow by window
/*
* by를 사용하지 않는 경우 위임
class UI(window: IWindow) : IWindow {
    val mWindow: IWindow = window

    override fun getWidth(): Int {
        return mWindow.getWidth()
    }

    override fun getHeight(): Int {
        return mWindow.getHeight()
    }
}
*/


fun main() {
    val window: IWindow = TransparentWindow()
    val ui = UI(window)
    println("폭: ${ui.getWidth()}, 높이: ${ui.getHeight()}")
}