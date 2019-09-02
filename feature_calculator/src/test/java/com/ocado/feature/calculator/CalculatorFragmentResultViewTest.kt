package com.ocado.feature.calculator

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withText
import org.junit.Assert.assertEquals
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

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
    }

    @Test
    fun onRefreshEmptyResult_showEmptyText() {
        launchCalculatorFragment(presenter).onFragment { it.refreshResult("test") }
        onView(ViewMatchers.withId(R.id.view_result_text)).check(matches(withText("test")))
    }

    @Test
    fun onRefreshResult_showText() {
        launchCalculatorFragment(presenter).onFragment { it.refreshResult("") }
        onView(ViewMatchers.withId(R.id.view_result_text)).check(matches(withText("")))
    }

    @Test
    fun testGetResult_returnsRefreshedResult() {
        launchCalculatorFragment(presenter).onFragment {
            it.refreshResult("test")
            assertEquals("test", it.getResult())
        }
    }
}