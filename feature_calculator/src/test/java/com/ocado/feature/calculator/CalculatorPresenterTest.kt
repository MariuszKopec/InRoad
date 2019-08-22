package com.ocado.feature.calculator

import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.verify
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
        presenter.onKeyboardButtonClick("1")
        verify(view).refreshResult("1")
    }

    @Test
    fun verifyAppendInputToResult_onKeyboardButtonClick() {
        Mockito.`when`(view.getResult()).thenReturn("1")
        presenter.onKeyboardButtonClick("2")
        verify(view).refreshResult("12")
    }
}