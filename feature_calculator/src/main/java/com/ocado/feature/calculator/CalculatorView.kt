package com.ocado.feature.calculator

interface CalculatorView {
    fun refreshResult(input: String)
    fun getResult(): String
}