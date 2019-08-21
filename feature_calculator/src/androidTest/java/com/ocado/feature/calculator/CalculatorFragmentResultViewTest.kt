package com.ocado.feature.calculator

import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.ocado.feature.calculator.di.TestCalculatorFragmentModule
import com.ocado.feature.calculator.di.TestInjector
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.MockitoAnnotations

@RunWith(AndroidJUnit4::class)
class CalculatorFragmentResultViewTest {
    @Mock
    lateinit var presenter: CalculatorPresenter

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        TestInjector(TestCalculatorFragmentModule(presenter)).inject()
    }

    @Test
    fun onRefreshResult_showText() {
        onCalculatorView { it.refreshResult("test") }
        onView(ViewMatchers.withId(R.id.view_result_text)).check(matches(withText("test")))
    }

    @Test
    fun onRefreshEmptyResult_showEmptyText() {
        onCalculatorView { it.refreshResult("") }
        onView(ViewMatchers.withId(R.id.view_result_text)).check(matches(withText("")))
    }

    private fun onCalculatorView(block: (CalculatorView) -> Unit) {
        launchFragmentInContainer<CalculatorFragment>(themeResId = R.style.AppTheme).onFragment {
            block(it)
        }
    }
}