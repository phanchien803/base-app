package easy.base.extension

import android.app.Activity
import android.graphics.Color
import androidx.annotation.ColorRes
import androidx.core.content.ContextCompat
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent

class StatusBarColorHelper(private val activity: Activity, private @ColorRes val color: Int) :
    LifecycleObserver {

    private var originalColor: Int = Color.WHITE

    fun setLifecycle(lifecycle: Lifecycle) {
        lifecycle.addObserver(this)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    private fun setNewColor() {
        activity.apply {
            originalColor = window.statusBarColor
            window.statusBarColor = ContextCompat.getColor(this, color)
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    private fun restoreOriginalColor() {
        activity.apply {
            window.statusBarColor = originalColor
        }
    }
}