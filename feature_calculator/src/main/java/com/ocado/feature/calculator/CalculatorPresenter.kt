package com.ocado.feature.calculator

import com.ocado.domain.CalculateInteractor
import com.ocado.feature.base.OpenForTest
import javax.inject.Inject

@OpenForTest
class CalculatorPresenter @Inject constructor(private val view: CalculatorView,
                                              private val calculate: CalculateInteractor,
                                              private val formatter: CalculatorFormatter = CalculatorFormatter()) {

    fun onKeyboardButtonClick(input: String) = view.refreshResult(view.getResult() + input)

    fun onEqualsClick() {
        val result = calculate(view.getResult())
        view.refreshResult(formatter.format(result))
    }

    fun onClearClick() = view.getResult().let { result ->
        if (result.isNotEmpty()) {
            view.refreshResult(result.dropLast(1))
        }
    }
}