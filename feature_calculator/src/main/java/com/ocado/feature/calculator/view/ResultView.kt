package com.ocado.feature.calculator.view

import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout
import com.ocado.feature.calculator.R
import kotlinx.android.synthetic.main.view_result.view.*

@Suppress("UsePropertyAccessSyntax")
internal class ResultView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) :
    LinearLayout(context, attrs, defStyleAttr) {

    init {
        inflate(context, R.layout.view_result, this)
    }

    fun refresh(input: String) = view_result_text.setText(input)

    fun getText(): String = view_result_text.text.toString()
}