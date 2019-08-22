package com.ocado.feature.calculator

import com.ocado.domain.CalculateInteractor
import com.ocado.domain.CalculateInteractor.WrongExpressionException
import com.ocado.feature.base.Log
import com.ocado.feature.base.OpenForTest
import javax.inject.Inject

@OpenForTest
class CalculatorPresenter @Inject constructor(private val view: CalculatorView,
                                              private val calculate: CalculateInteractor,
                                              private val log: Log = Log(),
                                              private val formatter: CalculatorFormatter = CalculatorFormatter()) {

    fun onKeyboardButtonClick(input: String) = view.refreshResult(view.getResult() + input)

    fun onEqualsClick() {
        try {
            val result = calculate(view.getResult())
            view.refreshResult(formatter.format(result))
        } catch (e: WrongExpressionException) {
            log.e(javaClass.simpleName, "wrong expression")
        }
    }

    fun onClearClick() = view.getResult().let { result ->
        if (result.isNotEmpty()) {
            view.refreshResult(result.dropLast(1))
        }
    }
}