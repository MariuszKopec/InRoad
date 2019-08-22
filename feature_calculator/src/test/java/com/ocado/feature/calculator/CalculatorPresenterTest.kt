package com.ocado.feature.calculator

import com.ocado.domain.CalculateInteractor
import com.ocado.feature.base.Log
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class CalculatorPresenterTest {
    @Mock
    lateinit var view: CalculatorView
    @Mock
    lateinit var log: Log
    @Mock
    lateinit var calculate: CalculateInteractor
    lateinit var presenter: CalculatorPresenter

    @Before
    fun setup() {
        `when`(view.getResult()).thenReturn("")
        `when`(calculate(anyString())).thenReturn(0.0)
        presenter = CalculatorPresenter(view, calculate, log)
    }

    @Test
    fun refreshResult_onKeyboardButtonClick() {
        presenter.onKeyboardButtonClick("1")
        verify(view).refreshResult("1")
    }

    @Test
    fun refreshResultWithNewCharacter_onKeyboardButtonClick() {
        `when`(view.getResult()).thenReturn("1")
        presenter.onKeyboardButtonClick("2")
        verify(view).refreshResult("12")
    }

    @Test
    fun refreshResultWithoutLastCharacter_onClearClick() {
        `when`(view.getResult()).thenReturn("12")
        presenter.onClearClick()
        verify(view).refreshResult("1")
    }

    @Test
    fun doNotRefreshResultWhenEmpty_onClearClick() {
        presenter.onClearClick()
        verify(view, never()).refreshResult(anyString())
    }

    @Test
    fun verifyCalculateInvoke_onEqualsClick() {
        `when`(view.getResult()).thenReturn("123")
        presenter.onEqualsClick()
        verify(calculate).invoke("123")
    }

    @Test
    fun refreshCalculatorResultWithoutDecimals_onEqualsClick() {
        `when`(calculate(anyString())).thenReturn(123.0)
        presenter.onEqualsClick()
        verify(view).refreshResult("123")
    }

    @Test
    fun refreshCalculatorResultWithDecimals_onEqualsClick() {
        `when`(calculate(anyString())).thenReturn(123.123)
        presenter.onEqualsClick()
        verify(view).refreshResult("123.123")
    }

    @Test
    fun doNothingWhenCalculationError() {
        `when`(calculate(anyString())).thenThrow(CalculateInteractor.WrongExpressionException::class.java)
        presenter.onEqualsClick()
        verify(view, never()).refreshResult(anyString())
    }

    @Test
    fun logErrorWhenCalculateError() {
        `when`(calculate(anyString())).thenThrow(CalculateInteractor.WrongExpressionException::class.java)
        presenter.onEqualsClick()
        verify(log).e(anyString(), anyString())
    }
}