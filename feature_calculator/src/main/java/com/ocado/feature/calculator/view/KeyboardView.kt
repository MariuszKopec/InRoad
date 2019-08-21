package com.ocado.feature.calculator.view

import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout
import com.ocado.feature.calculator.R

internal class KeyboardView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) :
    LinearLayout(context, attrs, defStyleAttr) {

    init {
        inflate(context, R.layout.view_keyboard, this)
    }
}