package com.jejetrue.skillshiftapp.navigation

sealed class ProfileSetting {
    object EditProfile : AuthScreen(route = "EditProfile")

}