package com.ocado.domain

import javax.inject.Inject
import javax.script.ScriptEngineManager

@Suppress("UNUSED_PARAMETER")
class CalculateForRealWorldInteractor @Inject constructor() {

    operator fun invoke(input: String): String {
        try {
            return ScriptEngineManager().getEngineByName("JavaScript").eval(input).toString()
        } catch (e: Exception) {
            throw WrongExpressionException()
        }
    }
}