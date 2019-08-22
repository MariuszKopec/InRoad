package com.ocado.feature.calculator

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
    lateinit var presenter: CalculatorPresenter

    @Before
    fun setup() {
        presenter = CalculatorPresenter(view)
    }

    @Test
    fun verifyRefreshResult_onKeyboardButtonClick() {
        `when`(view.getResult()).thenReturn("")
        presenter.onKeyboardButtonClick("1")
        verify(view).refreshResult("1")
    }

    @Test
    fun verifyAppendInputToResult_onKeyboardButtonClick() {
        `when`(view.getResult()).thenReturn("1")
        presenter.onKeyboardButtonClick("2")
        verify(view).refreshResult("12")
    }

    @Test
    fun dropLastCharacter_onClearClick() {
        `when`(view.getResult()).thenReturn("12")
        presenter.onClearClick()
        verify(view).refreshResult("1")
    }

    @Test
    fun nothingChangeWithEmptyResult_onClearClick() {
        `when`(view.getResult()).thenReturn("")
        presenter.onClearClick()
        verify(view, never()).refreshResult(anyString())
    }
}