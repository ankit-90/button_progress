package com.buttonprogress

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.PorterDuff

import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.FrameLayout
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.layout_button_progress.view.*

class ProgressButton @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {


    private var listener: OnButtonClickListener? = null
    private var buttonText = ""

    init {
        initView(context, attrs)
    }


    private fun initView(context: Context, attrs: AttributeSet?) {

        LayoutInflater.from(context).inflate(R.layout.layout_button_progress, this, true)
        val styleable = context.theme.obtainStyledAttributes(attrs, R.styleable.btn_progress, 0, 0)
        buttonText = styleable.getString(R.styleable.btn_progress_btn_text)
        setText()
        button_submit.setOnClickListener {
            listener?.onButtonClick()
        }
        progress_bar
            .getIndeterminateDrawable()
            .setColorFilter(ContextCompat.getColor(getContext(), R.color.white), PorterDuff.Mode.SRC_IN )

    }

    private fun setText() {
        button_submit.text = buttonText
    }

    private fun clearText() {
        button_submit.text = ""
    }


    fun setButtonListener(listener: OnButtonClickListener) {
        this.listener = listener
    }


    fun disableButton() {
        button_submit.isEnabled = false
    }

    fun enableButton() {
        button_submit.isEnabled = true
    }


    fun showLoading() {
        progress_bar.visibility = View.VISIBLE
        clearText()

    }


    fun hideLoading() {
        progress_bar.visibility = View.GONE
        setText()
    }


    interface OnButtonClickListener {

        fun onButtonClick()

    }

}