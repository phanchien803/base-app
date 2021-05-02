package easy.app.base.extension

import android.app.Activity
import android.content.Context
import android.content.res.Resources
import android.os.SystemClock
import android.util.TypedValue
import android.view.View
import android.view.View.GONE
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.annotation.ColorRes
import androidx.appcompat.widget.Toolbar
import androidx.core.view.*
import androidx.fragment.app.Fragment
import easy.app.R

fun View.setOnDebouncedClickListener(action: (View) -> Unit) {
    val actionDebouncer = ActionDebouncer(action)

    // This is the only place in the project where we should actually use setOnClickListener
    setOnClickListener {
        actionDebouncer.notifyAction(it)
    }
}

fun View.removeOnDebouncedClickListener() {
    setOnClickListener(null)
    isClickable = false
}

private class ActionDebouncer(private val action: (View) -> Unit) {

    companion object {
        const val DEBOUNCE_INTERVAL_MILLISECONDS = 600L
    }

    private var lastActionTime = 0L

    fun notifyAction(view: View) {
        val now = SystemClock.elapsedRealtime()

        val millisecondsPassed = now - lastActionTime
        val actionAllowed = millisecondsPassed > DEBOUNCE_INTERVAL_MILLISECONDS
        lastActionTime = now

        if (actionAllowed) {
            action.invoke(view)
        }
    }
}

var View.visible
    get() = visibility == VISIBLE
    set(value) {
        visibility = if (value) VISIBLE else INVISIBLE
    }

fun View.hide(gone: Boolean = true) {
    visibility = if (gone) GONE else INVISIBLE
}

fun View.show() {
    visibility = VISIBLE
}

fun View.initViewStatusBar(@ColorRes backgroundColor: Int = R.color.dark_sky_blue) {
    ViewCompat.setOnApplyWindowInsetsListener(this) { _, insets ->
        updateLayoutParams<ViewGroup.MarginLayoutParams> { height = insets.systemWindowInsetTop }
        setBackgroundResource(backgroundColor)
        insets.consumeSystemWindowInsets()
    }
}

fun Toolbar.updateMarginWindowInsets() {
    ViewCompat.setOnApplyWindowInsetsListener(this) { _, insets ->
        updateLayoutParams<ViewGroup.MarginLayoutParams> { updateMargins(top = insets.systemWindowInsetTop) }
        insets.consumeSystemWindowInsets()
    }
}


fun Activity.actionbarHeight() : Int{
    val tv = TypedValue()
    if (theme.resolveAttribute(android.R.attr.actionBarSize, tv, true)) {
       return TypedValue.complexToDimensionPixelSize(tv.data, resources.displayMetrics)
    }
    return 56.px
}

inline fun <T> MutableList<T>.mapInPlace(mutator: (T)->T) {
    val iterate = this.listIterator()
    while (iterate.hasNext()) {
        val oldValue = iterate.next()
        val newValue = mutator(oldValue)
        if (newValue !== oldValue) {
            iterate.set(newValue)
        }
    }
}

val Int.dp: Int
    get() = (this / Resources.getSystem().displayMetrics.density).toInt()
val Int.px: Int
    get() = (this * Resources.getSystem().displayMetrics.density).toInt()

fun Fragment.hideKeyBoard(){
    requireActivity().currentFocus?.let { view ->
        val imm = requireContext().getSystemService(Context.INPUT_METHOD_SERVICE) as? InputMethodManager
        imm?.hideSoftInputFromWindow(view.windowToken, 0)
    }
}
