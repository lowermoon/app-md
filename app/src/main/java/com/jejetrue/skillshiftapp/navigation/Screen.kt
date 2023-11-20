package com.jejetrue.skillshiftapp.navigation

sealed class Screen(val route:String) {
    object LoginScreen : Screen("login")
    object SignupScreen : Screen("signup")
    object VerifyEmailScreen : Screen("verifyEmail")


}