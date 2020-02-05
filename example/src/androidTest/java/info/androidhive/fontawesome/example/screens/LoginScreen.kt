package info.androidhive.fontawesome.example.screens

import androidx.test.espresso.matcher.ViewMatchers.withId
import info.androidhive.fontawesome.example.R

object LoginScreen : BaseScreen() {
    fun isScreenDisplayed() {
        super.isScreenDisplayed(withId(R.id.login_root_parent)) // корневой родитель всех вьюх данного скрина
    }
}