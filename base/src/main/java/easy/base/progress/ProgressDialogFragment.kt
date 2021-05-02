package easy.base.progress

import android.app.ActionBar
import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import easy.base.R
import easy.base.databinding.FragmentProgressDialogBinding

class ProgressDialogFragment : DialogFragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        isCancelable = false
    }

    override fun getTheme(): Int = R.style.ProgressDialogTheme

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return object : Dialog(requireActivity(), theme) {
            override fun onAttachedToWindow() {
                super.onAttachedToWindow()
                this.window?.apply {
                    setLayout(ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.MATCH_PARENT)
                }
            }
        }
    }

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View = FragmentProgressDialogBinding.inflate(inflater, container, false).root


    companion object {
        const val PROGRESS_TAG = "progress_dialog"
        fun newInstance() = ProgressDialogFragment()
    }
}