package easy.app.base.extension

import android.os.Bundle
import androidx.core.os.bundleOf

fun Bundle.putAny(key: String, value: Any?) {
    putAll(bundleOf(key to value))
}