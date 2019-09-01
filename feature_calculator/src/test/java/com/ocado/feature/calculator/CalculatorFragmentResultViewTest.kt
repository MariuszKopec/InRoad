package com.ocado.feature.calculator

import androidx.fragment.app.testing.FragmentScenario
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withText
import com.ocado.feature.calculator.di.TestApplication
import com.ocado.feature.calculator.di.TestCalculatorFragmentModule
import com.ocado.feature.calculator.di.TestInjector
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(application = TestApplication::class)
class CalculatorFragmentResultViewTest {
    @Mock
    lateinit var presenter: CalculatorPresenter
    private lateinit var fragmentScenario: FragmentScenario<CalculatorFragment>

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        TestInjector(TestCalculatorFragmentModule(presenter)).inject()
        fragmentScenario = launchFragmentInContainer(themeResId = R.style.AppTheme)
    }

    @Test
    fun onRefreshEmptyResult_showEmptyText() {
        fragmentScenario.onFragment { it.refreshResult("test") }
        onView(ViewMatchers.withId(R.id.view_result_text)).check(matches(withText("test")))
    }

    @Test
    fun onRefreshResult_showText() {
        fragmentScenario.onFragment { it.refreshResult("") }
        onView(ViewMatchers.withId(R.id.view_result_text)).check(matches(withText("")))
    }
}