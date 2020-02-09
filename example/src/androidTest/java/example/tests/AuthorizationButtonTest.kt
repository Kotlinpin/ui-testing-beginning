package example.tests

import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import example.custom.actions.clickOnView
import example.screens.BeginScreen
import example.screens.LoginScreen
import info.androidhive.fontawesome.example.MainActivity
import info.androidhive.fontawesome.example.R
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class AuthorizationButtonTest {

    /**
     *   Обязательная инструкция по инициализации ActivityTestRule'a,
     *   c помощью которого мы стартуем приложение, используя метод launchActivity
     *   Вообще целесообразно вынести код с 29-й по 35-й строку в какой-нибудь базовый класс,
     *   например, BaseTest и все тестовые классы (в т.ч. и этот) наследовать от него
     */
    @JvmField
    val activityRule = ActivityTestRule(MainActivity::class.java, true, false)

    @Before
    fun setUp() {
        activityRule.launchActivity(null)
    }

    @Test
    fun should_press_on_auth_button_then_check_is_auth_screen_opened() {
        onView(
          withText(R.string.btn_auth_title) //  или withId(R.id.button_auth)
        ).perform(
            click()   // ViewAction
        )
        onView(
            withId(R.id.login_root_parent) // Matcher<View>
        ).check(
            matches(isDisplayed())    // ViewAssertion
        )
    }

    // Тот же самый тест, что и выше, но только на паттерне PageObject
    @Test
    fun should_press_on_auth_button_then_check_is_auth_screen_opened_2() {
        BeginScreen.isScreenDisplayed()     // проверяем отображается ли скрин
        clickOnView(BeginScreen.authButton) // кликаем на его ui-элемент
        LoginScreen.isScreenDisplayed()     // проверяем отображение нового скрина
    }

    @Test
    fun should_press_on_auth_button_then_get_back_and_press_skip() {

        //шаг1: нажимаем  на кнопку Авторизоваться  "Авторизоваться"
        onView(
            withText(R.string.btn_auth_title)
        ).perform(
            click()
        )

        //шаг2: нажимаем  назад
        Espresso.pressBack()

        //шаг3: нажимаем  на кнопку "Пропустить"
        onView(
            withText(R.string.btn_skip_title)
        ).perform(
            click()
        )

        //шаг4: проверяем отображение вьюшки с тесктом "SkipButton was pressed"
        onView(
            withText(R.string.skip_btn_pressed_notification)
        ).check(
            matches(isDisplayed())
        )
    }
}