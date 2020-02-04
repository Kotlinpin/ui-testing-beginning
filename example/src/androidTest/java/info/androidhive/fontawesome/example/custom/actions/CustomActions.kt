package info.androidhive.fontawesome.example.custom.actions

import android.view.View
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.action.ViewActions.*
import org.hamcrest.Matcher

fun clickOnView(viewMatcher: Matcher<View>): ViewInteraction {
    return onView(viewMatcher).perform(click())
}

fun doubleClickOnView(viewMatcher: Matcher<View>): ViewInteraction {
    return onView(viewMatcher).perform(doubleClick())
}

fun longClickOnView(viewMatcher: Matcher<View>): ViewInteraction {
    return onView(viewMatcher).perform(longClick())
}