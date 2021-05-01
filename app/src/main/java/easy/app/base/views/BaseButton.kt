package easy.app.base.views

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.widget.FrameLayout
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import androidx.core.view.updateLayoutParams
import androidx.core.view.updatePadding
import easy.app.R
import easy.app.base.extension.hide
import easy.app.base.extension.px
import easy.app.base.extension.setOnDebouncedClickListener
import easy.app.base.extension.show
import easy.app.databinding.LayoutBaseButtonBinding

class BaseButton @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {
    private var buttonText: String? = ""
    private var buttonTextSize: Int = 0
    private var buttonTextColor: Int = 0
    private var buttonTextFont: Int = 0
    private var iconDrawable: Drawable? = null
    private var disableDrawable: Drawable? = null
    private var currentDrawable: Drawable? = null
    private var loading: Boolean = false
    private var isEnable: Boolean = true

    private val binding = LayoutBaseButtonBinding.inflate(LayoutInflater.from(context), this, true)

    init {
        val type: Int?
        val size: Int?
        val text: String?
        val icon: Drawable?
        val iconSize: Int?
        val background: Drawable?
        var enabled: Boolean
        var paddingHorizontal: Int?
        var paddingVertical: Int?
        val normalButtonBlueDrawable = R.drawable.bg_button
        val outlinedButtonDrawable = R.drawable.bg_button_outline
        val textButtonDrawable = R.drawable.bg_button_text
        val disableButtonDrawable = R.drawable.bg_button_disable
        disableDrawable = ContextCompat.getDrawable(context, disableButtonDrawable)
        context.obtainStyledAttributes(attrs, R.styleable.BaseButton).apply {
            type = getInt(R.styleable.BaseButton_button_type, 0)
            text = getString(R.styleable.BaseButton_text) ?: ""
            buttonTextSize = getDimensionPixelSize(R.styleable.BaseButton_text_size, 0)
            iconSize = getDimensionPixelSize(R.styleable.BaseButton_icon_size, 16.px)
            paddingHorizontal = getDimensionPixelSize(R.styleable.BaseButton_padding_horizontal, 16.px)
            paddingVertical = getDimensionPixelSize(R.styleable.BaseButton_padding_vertical, 10.px)
            buttonTextColor = getColor(R.styleable.BaseButton_text_color, 0)
            buttonTextFont = getResourceId(R.styleable.BaseButton_text_font, 0)
            icon = getDrawable(R.styleable.BaseButton_icon)
            background = getDrawable(R.styleable.BaseButton_background_color)
            enabled = getBoolean(R.styleable.BaseButton_enabled, true)
            recycle()
        }

        text?.let {
            buttonText = text
            binding.textButtonText.text = text
        }
        if (buttonTextSize != 0) binding.textButtonText.setTextSize(TypedValue.COMPLEX_UNIT_PX, buttonTextSize.toFloat())
        paddingHorizontal?.let {
            binding.layoutButton.updatePadding(left = it, right = it)
        }
        paddingVertical?.let {
            binding.layoutButton.updatePadding(top = it, bottom = it)
        }
        icon?.let {
            iconDrawable = icon
            binding.imageIcon.setImageDrawable(iconDrawable)
        } ?: kotlin.run { binding.imageIcon.hide() }
        iconSize?.let {
            binding.imageIcon.updateLayoutParams {
                width = it
                height = it
            }
        }
        when (type) {
            ButtonType.BUTTON_TYPE_NORMAL.ordinal -> {
                currentDrawable = ContextCompat.getDrawable(context, normalButtonBlueDrawable)
                binding.layoutButton.background =
                    ContextCompat.getDrawable(context, normalButtonBlueDrawable)
                binding.textButtonText.setTextColor(Color.WHITE)
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                    binding.textButtonText.typeface = resources.getFont(R.font.lato)
                } else {
                    binding.textButtonText.typeface = ResourcesCompat.getFont(context, R.font.lato)
                }
            }
            ButtonType.BUTTON_TYPE_OUTLINED.ordinal -> {
                currentDrawable = ContextCompat.getDrawable(context, outlinedButtonDrawable)
                binding.layoutButton.background =
                    ContextCompat.getDrawable(context, outlinedButtonDrawable)
                binding.textButtonText.setTextColor(
                    ContextCompat.getColor(
                        context,
                        R.color.bluish_two
                    )
                )
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                    binding.textButtonText.typeface = resources.getFont(R.font.lato)
                } else {
                    binding.textButtonText.typeface = ResourcesCompat.getFont(context, R.font.lato)
                }
            }
            ButtonType.BUTTON_TYPE_TEXT.ordinal -> {
                currentDrawable = ContextCompat.getDrawable(context, textButtonDrawable)
                binding.layoutButton.background =
                    ContextCompat.getDrawable(context, textButtonDrawable)
                binding.textButtonText.setTextColor(
                    ContextCompat.getColor(
                        context,
                        R.color.white
                    )
                )
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                    binding.textButtonText.typeface = resources.getFont(R.font.lato)
                } else {
                    binding.textButtonText.typeface = ResourcesCompat.getFont(context, R.font.lato)
                }
            }
        }
        background?.let {
            currentDrawable = background
            binding.layoutButton.background = background
        }
        isEnable = enabled
        if (!isEnable) binding.layoutButton.background = disableDrawable
        if (buttonTextColor != 0) binding.textButtonText.setTextColor(buttonTextColor)
        if (buttonTextFont != 0)  {
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                    binding.textButtonText.typeface = resources.getFont(buttonTextFont)
                } else {
                    binding.textButtonText.typeface = ResourcesCompat.getFont(context, buttonTextFont)
                }
        }
    }


    fun setViewOnClickListener(clickListener: OnClickListener) {
        binding.layoutButton.setOnClickListener { clickListener.onClick(it) }
    }

    fun setOnDebouncedClickListener(clickListener: ((View) -> Unit)) {
        binding.layoutButton.setOnDebouncedClickListener { clickListener.invoke(it) }
    }

    fun setText(text: String) {
        buttonText = text
        binding.textButtonText.text = text
    }

    fun setIcon(icon: Drawable?) {
        iconDrawable = icon
        binding.imageIcon.setImageDrawable(iconDrawable)
    }

    fun startLoading() {
        if (!loading) {
            loading = true
            binding.textButtonText.text = ""
            binding.imageIcon.hide()
            binding.textButtonText.hide()
            binding.layoutButton.isClickable = false
            binding.progressBarLoading.show()
        }
    }

    fun stopLoading() {
        if (loading) {
            loading = false
            binding.textButtonText.text = buttonText
            iconDrawable?.let { binding.imageIcon.show() }
            binding.textButtonText.show()
            binding.layoutButton.isClickable = true
            binding.progressBarLoading.hide()
        }
    }

    fun setEnable(isEnable : Boolean) {
        this.isEnable = isEnable
        binding.layoutButton.background = if (isEnable) currentDrawable else disableDrawable
    }

    companion object {
        enum class ButtonType(value: Int) {
            BUTTON_TYPE_NORMAL(0),
            BUTTON_TYPE_OUTLINED(1),
            BUTTON_TYPE_TEXT(2),
        }
    }
}