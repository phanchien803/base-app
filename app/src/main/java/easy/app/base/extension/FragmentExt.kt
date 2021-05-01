package easy.app.base.extension

import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.OnLifecycleEvent
import androidx.navigation.NavDirections
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import easy.app.R
import timber.log.Timber
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

fun <T> Fragment.viewLifecycle(): ReadWriteProperty<Fragment, T> =
    object : ReadWriteProperty<Fragment, T>, LifecycleObserver {

        private var binding: T? = null

        init {
            // Observe the view lifecycle of the Fragment.
            // The view lifecycle owner is null before onCreateView and after onDestroyView.
            // The observer is automatically removed after the onDestroy event.
            this@viewLifecycle
                .viewLifecycleOwnerLiveData
                .observe(this@viewLifecycle) { owner: LifecycleOwner? ->
                    owner?.lifecycle?.addObserver(this)
                }
        }

        @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
        fun onDestroy(owner: LifecycleOwner) {
            binding = null
        }

        override fun getValue(
            thisRef: Fragment,
            property: KProperty<*>
        ): T {
            return this.binding ?: error("Called before onCreateView or after onDestroyView.")
        }

        override fun setValue(
            thisRef: Fragment,
            property: KProperty<*>,
            value: T
        ) {
            this.binding = value
        }
    }

fun Fragment.navigateSafe(directions: NavDirections, navOptions: NavOptions? = null) {
    if (canNavigate()) findNavController().navigate(directions, navOptions)
}

/**
 * Returns true if the navigation controller is still pointing at 'this' fragment, or false
 * if it already navigated away.
 */
fun Fragment.canNavigate(): Boolean {
    val navController = findNavController()
    val destinationIdInNavController = navController.currentDestination?.id

    // add tag_navigation_destination_id to your res\values\ids.xml so that it's unique:
    val destinationIdOfThisFragment = view?.getTag(R.id.tag_navigation_destination_id) ?: destinationIdInNavController

    // check that the navigation graph is still in 'this' fragment, if not then the app already navigated:
    return if (destinationIdInNavController == destinationIdOfThisFragment) {
        view?.setTag(R.id.tag_navigation_destination_id, destinationIdOfThisFragment)
        true
    } else {
        Timber.d("May not navigate: current destination is not the current fragment.")
        false
    }
}

fun Fragment.popAllBackStack() {
    while (findNavController().popBackStack()){
        //
    }
}

