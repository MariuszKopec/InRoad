package com.ocado.feature.calculator

import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class ExampleUnitTest {

    @Mock
    lateinit var view: CalculatorView

    @Test
    fun addition_isCorrect() {
        assertEquals(4, (2 + 2).toLong())
    }
}