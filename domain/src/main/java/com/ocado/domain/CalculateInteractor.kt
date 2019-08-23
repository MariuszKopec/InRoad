package com.ocado.domain

import java.util.*
import javax.inject.Inject

class CalculateInteractor @Inject constructor() {

    operator fun invoke(input: String): Double = try {
        val values = getValuesStack(input)
        getOperators(input).forEach {
            when (it) {
                '+' -> values.addFirst(values.poll() + values.poll())
                '-' -> values.addFirst(values.poll() - (values.poll() ?: 0.0))
            }
        }
        values.poll()
    } catch (e: Exception) {
        throw WrongExpressionException()
    }

    private fun getValuesStack(input: String) = LinkedList<Double>().apply {
        addAll(input.trimStart { it == '-' }.split("+", "-").filter { it.isNotEmpty() }.map { it.toDouble() })
        if (input.firstOrNull() == '-' && isNotEmpty()) set(0, get(0) * -1)
    }

    private fun getOperators(input: String) = input.trimStart { it == '-' }.filter { it == '+' || it == '-' }

    class WrongExpressionException : RuntimeException()
}