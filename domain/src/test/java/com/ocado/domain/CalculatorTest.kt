package com.ocado.domain

import junit.framework.Assert.assertEquals
import org.junit.Test

class CalculatorTest {

    @Test
    fun test() {
        val calculator = Calculator("1")
        assertEquals(calculator.result(), "1")
    }
}