package com.jejetrue.skillshiftapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.jejetrue.skillshiftapp.view.home.HomeScreen
import com.jejetrue.skillshiftapp.view.login.login.LoginScreen
import com.jejetrue.skillshiftapp.view.register.signup.SignupScreen

@Composable
fun Nav() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "login"){
        composable("login"){
            LoginScreen(navController)
        }

        composable(route= "register"){
            SignupScreen(navController)
        }

        composable(route= "home"){
            HomeScreen(navController)
        }

    }

}