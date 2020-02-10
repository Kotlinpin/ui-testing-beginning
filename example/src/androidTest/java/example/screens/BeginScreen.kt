package example.screens

import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import info.androidhive.fontawesome.example.R

object BeginScreen : BaseScreen() {
    fun isScreenDisplayed() {
        super.isScreenDisplayed(withId(R.id.begin_screen_parent)) // корневой родитель всех вьюх данного скрина)
    }

    val authButton = withText(R.string.btn_auth_title)
    val skipButton = withText(R.string.btn_skip_title)
}