package com.ocado.feature.calculator

import androidx.fragment.app.testing.FragmentScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withText
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class CalculatorFragmentResultViewTest {
    @Mock
    lateinit var presenter: CalculatorPresenter
    private lateinit var fragmentScenario: FragmentScenario<CalculatorFragment>

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        fragmentScenario = launchCalculatorFragment(presenter)
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