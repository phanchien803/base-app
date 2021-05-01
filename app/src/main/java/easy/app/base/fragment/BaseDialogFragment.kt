package easy.app.base.fragment

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.View
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import easy.app.base.viewmodel.BaseViewModel
import easy.app.base.viewmodel.ViewError
import dagger.hilt.android.AndroidEntryPoint
import easy.app.R
import easy.app.base.progress.ProgressDialogFragment
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@AndroidEntryPoint
abstract class BaseDialogFragment() : DialogFragment() {

    protected abstract val viewModel: BaseViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(
            STYLE_NO_TITLE,
            R.style.Home_Theme
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        view.findViewById<Toolbar>(R.id.toolbar)?.apply {
            setNavigationOnClickListener {
                findNavController().popBackStack()
            }
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
               this@BaseDialogFragment.handleOnBackPressed()
            }
        })
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