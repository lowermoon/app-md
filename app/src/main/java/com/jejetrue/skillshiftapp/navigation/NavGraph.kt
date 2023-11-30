package com.jejetrue.skillshiftapp.navigation

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.jejetrue.skillshiftapp.view.home.HomeScreen
import com.jejetrue.skillshiftapp.view.login.login.LoginScreen
import com.jejetrue.skillshiftapp.view.register.otp.VerifyAccount
import com.jejetrue.skillshiftapp.view.register.signup.SignupScreen

@Composable
fun Nav(destination: String = "login") {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = destination){
        composable("login"){
            LoginScreen(navController)
        }

        composable(route= "register"){
            SignupScreen(navController, navigateToVerif = {
                navController.navigate(Screen.VerifyEmailScreen.createRoute(it))
            })
        }
        composable(
            route = Screen.VerifyEmailScreen.route,
            arguments = listOf(navArgument("email"){
                type = NavType.StringType
            })
        ) {
            val email = it.arguments?.getString("email") ?: ""
            VerifyAccount(email)
        }

        composable(route= "home"){
            HomeScreen(navController)
        }

    }

}
