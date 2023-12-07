package com.jejetrue.skillshiftapp.navigation

sealed class Screen(val route:String) {
    object LoginScreen : Screen("login")
    object SignupScreen : Screen("signup")
    object VerifyEmailScreen : Screen("verif/{email}/{tokenRegis}"){
        fun createRoute(email: String, tokenRegis: String) = "verif/$email/$tokenRegis"
    }
    object Profile: Screen("profile")

}