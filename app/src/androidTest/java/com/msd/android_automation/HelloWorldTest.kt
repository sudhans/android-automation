package com.msd.android_automation


import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class HelloWorldTest {

    // Launches MainActivity before each test
    @get:Rule
    var activityRule: ActivityScenarioRule<MainActivity> =
        ActivityScenarioRule(MainActivity::class.java) // Replace MainActivity if your activity has a different name

    @Test
    fun checkHelloWorldTextIsDisplayed() {
        // Check if the TextView is displayed
        onView(withId(R.id.helloWorldView))
            .check(matches(isDisplayed()))

        // Check if the TextView has the text "Hello World!"
        onView(withId(R.id.helloWorldView))
            .check(matches(withText("Hello World!")))
    }
}