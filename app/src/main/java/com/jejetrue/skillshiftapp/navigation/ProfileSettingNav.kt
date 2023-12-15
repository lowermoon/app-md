package com.jejetrue.skillshiftapp.navigation

sealed class ProfileSetting(val route: String) {
    object EditProfile : AuthScreen(route = "EditProfile")

}