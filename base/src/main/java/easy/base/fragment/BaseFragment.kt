package easy.base.fragment

import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import easy.base.viewmodel.BaseViewModel
import easy.base.viewmodel.ViewError
import dagger.hilt.android.AndroidEntryPoint
import easy.base.extension.hideKeyBoard
import easy.base.progress.ProgressDialogFragment
import easy.base.R
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@AndroidEntryPoint
abstract class BaseFragment() : Fragment() {

    private var isFromBackStack = false

    protected fun isFromBackStack() = isFromBackStack

    protected abstract val viewModel: BaseViewModel

    protected fun viewOwnerLifecycleScope() = viewLifecycleOwner.lifecycleScope

    protected fun viewOwnerLifecycle() = viewLifecycleOwner.lifecycle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        isFromBackStack = false
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        hideKeyBoard()
        view.findViewById<Toolbar>(R.id.toolbar)?.apply {
            setNavigationOnClickListener {
                handleOnBackPressed()
            }
            contentInsetStartWithNavigation = 0
        }
        viewModel.errorsFlow
            .flowWithLifecycle(viewLifecycleOwner.lifecycle)
            .onEach { viewError ->
                val errorMessage = when (viewError) {
                    is ViewError.ResourceError -> getString(viewError.resId)
                    is ViewError.StringError -> viewError.error
                }
                showError(errorMessage)
            }
            .launchIn(viewLifecycleOwner.lifecycleScope)
        viewModel.progressFlow
            .flowWithLifecycle(viewLifecycleOwner.lifecycle)
            .onEach { showProgress(it) }
            .launchIn(viewLifecycleOwner.lifecycleScope)
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
               this@BaseFragment.handleOnBackPressed()
            }
        })
    }

    override fun onStart() {
        super.onStart()
        requireActivity().window.decorView.apply {
            setBackgroundColor(Color.WHITE)
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        isFromBackStack = true
    }

    private fun showProgress(visible: Boolean) {
        val fragment = childFragmentManager.findFragmentByTag(ProgressDialogFragment.PROGRESS_TAG)
        if (fragment != null && !visible) {
            (fragment as ProgressDialogFragment).dismissAllowingStateLoss()
            childFragmentManager.executePendingTransactions()
        } else if (fragment == null && visible) {
            ProgressDialogFragment.newInstance()
                .show(childFragmentManager, ProgressDialogFragment.PROGRESS_TAG)
            childFragmentManager.executePendingTransactions()
        }
    }

    protected fun handleOnBackPressed() {
        if (!findNavController().popBackStack()) {
            requireActivity().finish()
        }
    }

    private fun showError(errorMessage: String) {

    }

}