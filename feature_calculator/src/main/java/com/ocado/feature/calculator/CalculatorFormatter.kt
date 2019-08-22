package com.ocado.feature.calculator

import javax.inject.Inject

class CalculatorFormatter @Inject constructor() {

    fun format(input: Double): String {
        return if (input.compareTo(input.toLong()) == 0) {
            input.toLong().toString()
        } else {
            input.toString()
        }
    }
}