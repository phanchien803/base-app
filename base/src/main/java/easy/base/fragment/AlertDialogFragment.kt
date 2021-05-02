package easy.base.fragment

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.fragment.app.DialogFragment
import dagger.hilt.android.AndroidEntryPoint
import easy.base.views.BaseButton
import easy.base.R
import java.io.Serializable

@AndroidEntryPoint
class AlertDialogFragment() : DialogFragment() {

    private var isAutoDismiss: Boolean = true
    private var positiveButtonText: String? = null
    private var positiveButtonClickListener: View.OnClickListener = View.OnClickListener { dismiss() }
    private var negativeButtonText: String? = null
    private var negativeButtonClickListener: View.OnClickListener = View.OnClickListener { dismiss() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(
            STYLE_NO_TITLE,
            R.style.Home_Theme
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        when (requireArguments().getSerializable(ALERT_TYPE)) {
            is AlertType.Confirm -> return inflater.inflate(R.layout.alert_confirm, container, false)
        }
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        handleConfirmType(view)
    }

    private fun handleConfirmType(view: View) {
        view.findViewById<BaseButton>(R.id.button_ok)?.apply {
            setViewOnClickListener(positiveButtonClickListener)
            setText(positiveButtonText ?: getString(R.string.ok))
        }
        view.findViewById<BaseButton>(R.id.button_cancel)?.apply {
            setViewOnClickListener(negativeButtonClickListener)
            setText(negativeButtonText ?: getString(R.string.cancel))
        }
        val textMessage : TextView? = view.findViewById(R.id.text_message)
        val message = requireArguments().getString(MESSAGE)
        textMessage?.text = message
    }

    fun setAutoDismiss(autoDismiss: Boolean) = this.apply {
        isAutoDismiss = autoDismiss
    }

    fun setPositiveButton(actionText: String? = null, listener: ((dialog: DialogFragment) -> Unit)? = null) = this.apply {
        positiveButtonText = actionText
        listener?.let { action ->
            positiveButtonClickListener = View.OnClickListener {
                action.invoke(this)
                if (isAutoDismiss) dismiss()
            }
        }
    }

    fun setNegativeButton(actionText: String? = null, listener: ((dialog: DialogFragment) -> Unit)? = null) = this.apply {
        negativeButtonText = actionText
        listener?.let { action ->
            negativeButtonClickListener = View.OnClickListener {
                action.invoke(this)
                if (isAutoDismiss) dismiss()
            }
        }
    }

   companion object {
       private const val ALERT_TYPE = "alert_type"
       private const val MESSAGE = "message"

       private fun newInstance(alertType: AlertType): AlertDialogFragment {
           val args = bundleOf(ALERT_TYPE to alertType)
           val fragment = AlertDialogFragment()
           fragment.arguments = args
           return fragment
       }

       fun newConfirmInstance(message: String) = newInstance(AlertType.Confirm).apply { arguments =
           requireArguments().apply { putString(
               MESSAGE, message) }
       }
   }
}


sealed class AlertType : Serializable{
    object Confirm : AlertType()
}