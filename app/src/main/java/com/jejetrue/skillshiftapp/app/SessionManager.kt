package com.jejetrue.skillshiftapp.app

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel

class UserModel: ViewModel() {
    var appJustLaunched by mutableStateOf(true)
    var userIsAuthenticated by mutableStateOf(false)

    fun login() {
        userIsAuthenticated = true
        appJustLaunched = false
    }

    fun logout() {
        userIsAuthenticated = false
    }
}