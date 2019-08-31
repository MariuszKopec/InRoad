package com.inroad

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import com.ocado.feature.calculator.R
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class CalculatorAcceptanceTests {
    @get:Rule
    var activityRule: ActivityTestRule<MainActivity> = ActivityTestRule(MainActivity::class.java)

    @Test
    fun verifyAcceptanceCriterias() {
        asTheButtonsArePressedTheyAreEnteredIntoTheOutputView()
        whenEqualsIsPressedTheOutputViewWouldDisplayResult()
        afterResultHasBeenCalculatedNewInputOperationsWillBeAppliedToTheResultCurrentlyDisplayedInTheOutputField()
        whenEqualsIsPressedTheOutputViewWouldDisplayResultAgain()
    }

    private fun asTheButtonsArePressedTheyAreEnteredIntoTheOutputView() {
        onView(withId(R.id.view_keyboard_1)).perform(ViewActions.click())
        onView(withId(R.id.view_keyboard_2)).perform(ViewActions.click())
        onView(withId(R.id.view_keyboard_plus)).perform(ViewActions.click())
        onView(withId(R.id.view_keyboard_6)).perform(ViewActions.click())
        onView(withId(R.id.view_keyboard_5)).perform(ViewActions.click())
        onView(withId(R.id.view_keyboard_minus)).perform(ViewActions.click())
        onView(withId(R.id.view_keyboard_7)).perform(ViewActions.click())

        onView(withId(R.id.view_result_text)).check(matches(withText("12+65-7")))
    }

    private fun whenEqualsIsPressedTheOutputViewWouldDisplayResult() {
        onView(withId(R.id.view_keyboard_equals)).perform(ViewActions.click())
        onView(withId(R.id.view_result_text)).check(matches(withText("70")))
    }

    private fun afterResultHasBeenCalculatedNewInputOperationsWillBeAppliedToTheResultCurrentlyDisplayedInTheOutputField() {
        onView(withId(R.id.view_keyboard_plus)).perform(ViewActions.click())
        onView(withId(R.id.view_keyboard_1)).perform(ViewActions.click())
        onView(withId(R.id.view_keyboard_6)).perform(ViewActions.click())
        onView(withId(R.id.view_keyboard_minus)).perform(ViewActions.click())
        onView(withId(R.id.view_keyboard_2)).perform(ViewActions.click())

        onView(withId(R.id.view_result_text)).check(matches(withText("70+16-2")))
    }

    private fun whenEqualsIsPressedTheOutputViewWouldDisplayResultAgain() {
        onView(withId(R.id.view_keyboard_equals)).perform(ViewActions.click())
        onView(withId(R.id.view_result_text)).check(matches(withText("84")))
    }
}