package com.ocado.feature.calculator.di

import androidx.test.platform.app.InstrumentationRegistry
import com.ocado.feature.base.di.TestApplication

class TestInjector(private val testApplicationModule: TestCalculatorFragmentModule) {

    fun inject() {
        val app = InstrumentationRegistry.getInstrumentation().targetContext.applicationContext as? TestApplication
        DaggerTestApplicationComponent
            .builder()
            .appModule(testApplicationModule)
            .create(app)
            .inject(app)
    }
}