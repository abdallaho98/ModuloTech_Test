package com.example.modulotech_test.views.ui.account

import android.R
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.closeSoftKeyboard
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import androidx.test.rule.ActivityTestRule
import com.example.modulotech_test.views.MainActivity
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4ClassRunner::class)
class MainActivityEspressoTest {

    @get:Rule
    val activityRule = ActivityTestRule(MainActivity::class.java, false, false)

    @Test
    fun appLaunchesSuccessfully() {
        ActivityScenario.launch(MainActivity::class.java)

    }

    /*
    @Test
    fun enterAccountFragment() {
        // Type text and then press the button.
        onView(withId(R.id.inputField))
            .perform(typeText("HELLO"), closeSoftKeyboard())
        onView(withId(R.id.changeText)).perform(click())

        // Check that the text was changed.
        onView(withId(R.id.inputField)).check(matches(withText("Lalala")))
    }

     */
}