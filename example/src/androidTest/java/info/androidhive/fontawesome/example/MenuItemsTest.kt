package info.androidhive.fontawesome.example

import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withContentDescription
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import org.hamcrest.Matchers
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@Suppress("DEPRECATION")
@RunWith(AndroidJUnit4::class)
class MenuItemsTest {

    @get:Rule
    @JvmField
    val activityRule = ActivityTestRule(MainActivity::class.java, true, false)

    @Before
    fun setUp() {
        activityRule.launchActivity(null)
    }

    @Test
    fun start_app() {
        openMenu()
    }

    private fun openMenu() {
        onView(
            Matchers.allOf(
                withContentDescription("Open navigation drawer"),
                ViewMatchers.isDisplayed()
            )
        ).perform(click())
        Espresso.pressBack()
    }
}