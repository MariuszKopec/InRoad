package com.ocado.domain

import java.math.BigDecimal
import java.util.*
import javax.inject.Inject

class CalculateInteractor @Inject constructor() {

    operator fun invoke(input: String): Double = try {
        val values = getValuesStack(input)
        getOperators(input).forEach {
            when (it) {
                '+' -> values.addFirst(values.poll().add(values.poll()))
                '-' -> values.addFirst(values.poll().subtract(values.poll() ?: BigDecimal.ZERO))
            }
        }
        values.poll().toDouble()
    } catch (e: Exception) {
        throw WrongExpressionException()
    }

    private fun getValuesStack(input: String) = LinkedList<BigDecimal>().apply {
        addAll(input.trimStart { it == '-' }.split("+", "-").filter { it.isNotEmpty() }.map { BigDecimal(it) })
        if (input.firstOrNull() == '-' && isNotEmpty()) set(0, get(0).negate())
    }

    private fun getOperators(input: String) =
        input.trimStart { it == '-' }.filter { it == '+' || it == '-' }

    class WrongExpressionException : RuntimeException()
}