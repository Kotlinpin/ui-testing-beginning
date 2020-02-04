@file:Suppress("DEPRECATION")

package info.androidhive.fontawesome.example.tests

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import info.androidhive.fontawesome.example.MainActivity
import info.androidhive.fontawesome.example.R
import info.androidhive.fontawesome.example.custom.actions.clickOnView
import info.androidhive.fontawesome.example.screens.BeginScreen
import info.androidhive.fontawesome.example.screens.BeginScreen.authButton
import info.androidhive.fontawesome.example.screens.LoginScreen
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class AuthorizationButtonTest {

    @JvmField
    val activityRule = ActivityTestRule(MainActivity::class.java, true, false)

    @Before
    fun setUp() {
        activityRule.launchActivity(null)
    }

    @Test
    fun should_press_on_auth_button_then_check_is_auth_screen_opened() {
        onView(
            withText(R.string.btn_auth_title) // Matcher<View>
        ).perform(
            click()   // ViewAction
        )

        onView(
            withId(R.id.auth_login_parent) // Matcher<View>
        ).check(
            matches(isDisplayed())    // ViewAssertion
        )
    }

    // Тот же самый тест, но только на паттерне PageObject
    @Test
    fun should_press_on_auth_button_then_check_is_auth_screen_opened_2() {
        BeginScreen.isScreenDisplayed()
        clickOnView(authButton)
        LoginScreen.isScreenDisplayed()
    }
}