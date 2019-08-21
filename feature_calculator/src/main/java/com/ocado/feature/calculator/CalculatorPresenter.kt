package com.ocado.feature.calculator

import com.ocado.feature.base.OpenForTest
import javax.inject.Inject

@OpenForTest
class CalculatorPresenter @Inject constructor(private val view: CalculatorView) {

    fun onKeyboardButtonClick(input: String) {
        view.refreshResult(input)
    }

    fun onEqualsClick() {
    }
}