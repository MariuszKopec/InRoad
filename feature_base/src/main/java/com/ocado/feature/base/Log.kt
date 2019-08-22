package com.ocado.feature.base

import android.util.Log
import javax.inject.Inject

class Log @Inject constructor() {

    fun e(tag: String, message: String) {
        Log.e(tag, message)
    }
}