package com.ocado.domain

import junit.framework.TestCase.assertEquals
import org.junit.Before
import org.junit.Test

class CalculatorTest {
    lateinit var calculate: CalculateInteractor

    @Before
    fun setup() {
        calculate = CalculateInteractor()
    }

    @Test
    fun testResult() {
        assertEquals(1.0, calculate("1"))
        assertEquals(4.0, calculate("2+2"))
        assertEquals(0.0, calculate("2-2"))
        assertEquals(2.0, calculate("2+2-2"))
        assertEquals(6.123, calculate("2.0+2.123+2"))
        assertEquals(2.123, calculate("2.0+2.123-2"))
        assertEquals(1.0, calculate("1+0.0000000000000000000000000000000000000000000000000000001-0.0000000000000000000000000000000000000000000000000000001"))
        assertEquals(-2.0, calculate("-2+2-2"))
    }

    @Test(expected = CalculateInteractor.WrongExpressionException::class)
    fun testWrongExpressionWithoutSeconOperator() {
        calculate("2+")
    }

    @Test(expected = CalculateInteractor.WrongExpressionException::class)
    fun testWrongExpressionWithDoubleOperator() {
        calculate("2++")
    }

    @Test(expected = CalculateInteractor.WrongExpressionException::class)
    fun testWrongExpressionWithNoValues() {
        calculate("+")
    }

    @Test(expected = CalculateInteractor.WrongExpressionException::class)
    fun testWrongExpressionWithWrongDecimal() {
        calculate("0..0")
    }
}