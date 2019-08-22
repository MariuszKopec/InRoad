package com.ocado.feature.calculator

import com.ocado.feature.base.OpenForTest
import javax.inject.Inject

@OpenForTest
class CalculatorPresenter @Inject constructor(private val view: CalculatorView) {

    fun onKeyboardButtonClick(input: String) {
        view.refreshResult(view.getResult() + input)
    }

    fun onEqualsClick() {
    }

    fun onClearClick() {
        val result = view.getResult()
        if (result.isNotEmpty()) {
            view.refreshResult(result.dropLast(1))
        }
    }
}