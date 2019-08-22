package com.ocado.feature.calculator

import com.ocado.domain.CalculateInteractor
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.ArgumentMatchers
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class CalculatorPresenterTest {
    @Mock
    lateinit var view: CalculatorView
    @Mock
    lateinit var calculate: CalculateInteractor
    lateinit var presenter: CalculatorPresenter

    @Before
    fun setup() {
        `when`(view.getResult()).thenReturn("")
        `when`(calculate(anyString())).thenReturn("")
        presenter = CalculatorPresenter(view, calculate)
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
    fun refreshCalculatorResult_onEqualsClick() {
        `when`(calculate(anyString())).thenReturn("123")
        presenter.onEqualsClick()
        verify(view).refreshResult("123")
    }
}