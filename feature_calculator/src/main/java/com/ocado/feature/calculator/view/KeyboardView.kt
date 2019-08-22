package com.ocado.feature.calculator.view

import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout
import com.ocado.feature.calculator.R
import kotlinx.android.synthetic.main.view_keyboard.view.*

internal class KeyboardView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) :
    LinearLayout(context, attrs, defStyleAttr) {

    lateinit var onButtonClick: (String) -> Unit
    lateinit var onEqualsClick: () -> Unit
    lateinit var onClearClick: () -> Unit

    init {
        inflate(context, R.layout.view_keyboard, this)
        view_keyboard_0.setOnClickListener { onButtonClick("0") }
        view_keyboard_1.setOnClickListener { onButtonClick("1") }
        view_keyboard_2.setOnClickListener { onButtonClick("2") }
        view_keyboard_3.setOnClickListener { onButtonClick("3") }
        view_keyboard_4.setOnClickListener { onButtonClick("4") }
        view_keyboard_5.setOnClickListener { onButtonClick("5") }
        view_keyboard_6.setOnClickListener { onButtonClick("6") }
        view_keyboard_7.setOnClickListener { onButtonClick("7") }
        view_keyboard_8.setOnClickListener { onButtonClick("8") }
        view_keyboard_9.setOnClickListener { onButtonClick("9") }
        view_keyboard_dot.setOnClickListener { onButtonClick(".") }
        view_keyboard_plus.setOnClickListener { onButtonClick("+") }
        view_keyboard_minus.setOnClickListener { onButtonClick("-") }
        view_keyboard_equals.setOnClickListener { onEqualsClick() }
        view_keyboard_clear.setOnClickListener { onClearClick() }
    }
}