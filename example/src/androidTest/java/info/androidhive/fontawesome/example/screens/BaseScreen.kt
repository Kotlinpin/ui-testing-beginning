package info.androidhive.fontawesome.example.screens

import android.view.View
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import org.hamcrest.Matcher
/**
 *   Наш базовый скрин, от которого наследуются все наши скрины
 */
abstract class BaseScreen {
    fun isScreenDisplayed(rootViewMatcher: Matcher<View>) {
        onView(
            rootViewMatcher
        ).check(
            matches(ViewMatchers.isDisplayed())
        )
    }
}