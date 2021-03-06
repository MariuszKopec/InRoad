package com.ocado.feature.calculator

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class CalculatorFragmentKeyboardViewTest {
    @Mock
    lateinit var presenter: CalculatorPresenter

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        launchCalculatorFragment(presenter)
    }

    @Test
    fun verifyOnKeyboardButtonClick_0() {
        onView(ViewMatchers.withId(R.id.view_keyboard_0)).perform(click())
        verify(presenter).onKeyboardButtonClick("0")
    }

    @Test
    fun verifyOnKeyboardButtonClick_1() {
        onView(ViewMatchers.withId(R.id.view_keyboard_1)).perform(click())
        verify(presenter).onKeyboardButtonClick("1")
    }

    @Test
    fun verifyOnKeyboardButtonClick_2() {
        onView(ViewMatchers.withId(R.id.view_keyboard_2)).perform(click())
        verify(presenter).onKeyboardButtonClick("2")
    }

    @Test
    fun verifyOnKeyboardButtonClick_3() {
        onView(ViewMatchers.withId(R.id.view_keyboard_3)).perform(click())
        verify(presenter).onKeyboardButtonClick("3")
    }

    @Test
    fun verifyOnKeyboardButtonClick_4() {
        onView(ViewMatchers.withId(R.id.view_keyboard_4)).perform(click())
        verify(presenter).onKeyboardButtonClick("4")
    }

    @Test
    fun verifyOnKeyboardButtonClick_5() {
        onView(ViewMatchers.withId(R.id.view_keyboard_5)).perform(click())
        verify(presenter).onKeyboardButtonClick("5")
    }

    @Test
    fun verifyOnKeyboardButtonClick_6() {
        onView(ViewMatchers.withId(R.id.view_keyboard_6)).perform(click())
        verify(presenter).onKeyboardButtonClick("6")
    }

    @Test
    fun verifyOnKeyboardButtonClick_7() {
        onView(ViewMatchers.withId(R.id.view_keyboard_7)).perform(click())
        verify(presenter).onKeyboardButtonClick("7")
    }

    @Test
    fun verifyOnKeyboardButtonClick_8() {
        onView(ViewMatchers.withId(R.id.view_keyboard_8)).perform(click())
        verify(presenter).onKeyboardButtonClick("8")
    }

    @Test
    fun verifyOnKeyboardButtonClick_9() {
        onView(ViewMatchers.withId(R.id.view_keyboard_9)).perform(click())
        verify(presenter).onKeyboardButtonClick("9")
    }

    @Test
    fun verifyOnKeyboardButtonClick_dot() {
        onView(ViewMatchers.withId(R.id.view_keyboard_dot)).perform(click())
        verify(presenter).onKeyboardButtonClick(".")
    }

    @Test
    fun verifyOnKeyboardButtonClick_equals() {
        onView(ViewMatchers.withId(R.id.view_keyboard_equals)).perform(click())
        verify(presenter).onEqualsClick()
    }

    @Test
    fun verifyOnKeyboardButtonClick_plus() {
        onView(ViewMatchers.withId(R.id.view_keyboard_plus)).perform(click())
        verify(presenter).onKeyboardButtonClick("+")
    }

    @Test
    fun verifyOnKeyboardButtonClick_minus() {
        onView(ViewMatchers.withId(R.id.view_keyboard_minus)).perform(click())
        verify(presenter).onKeyboardButtonClick("-")
    }

    @Test
    fun verifyOnKeyboardButtonClick_clear() {
        onView(ViewMatchers.withId(R.id.view_keyboard_clear)).perform(click())
        verify(presenter).onClearClick()
    }
}