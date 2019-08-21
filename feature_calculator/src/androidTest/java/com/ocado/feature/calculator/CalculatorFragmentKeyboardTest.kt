package com.ocado.feature.calculator

import androidx.test.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.ocado.feature.calculator.di.TestCalculatorFragmentModule
import com.ocado.feature.calculator.di.TestInjector
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.MockitoAnnotations

@RunWith(AndroidJUnit4::class)
class CalculatorFragmentKeyboardTest {
    @Mock
    lateinit var presenter: CalculatorPresenter

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        TestInjector(TestCalculatorFragmentModule(presenter)).inject()
    }

    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getTargetContext()

        assertEquals("com.ocado.feature.calculator.test", appContext.packageName)
    }
}
