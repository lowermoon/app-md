package com.jejetrue.skillshiftapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.jejetrue.skillshiftapp.view.home.HomeScreen
import com.jejetrue.skillshiftapp.view.login.emailverify.EmailVerify
import com.jejetrue.skillshiftapp.view.login.login.LoginScreen
import com.jejetrue.skillshiftapp.view.login.newpass.NewPassword
import com.jejetrue.skillshiftapp.view.login.otp.OtpVerify
import com.jejetrue.skillshiftapp.view.register.otp.VerifyAccount
import com.jejetrue.skillshiftapp.view.register.signup.SignupScreen

@Composable
fun Nav() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "login"){

        //REGISTER
        composable(route= "register"){
            SignupScreen(navController)
        }

        composable(route= "verifyAccont"){
            VerifyAccount(navController)
        }

        //LOGIN
        composable("login"){
            LoginScreen(navController)
        }


        //FORGOT PASSWORD
        composable(route= "emailVerify"){
            EmailVerify(navController)
        }

        composable(route = "otpVerify"){
            OtpVerify(navController)
        }

        composable(route = "newPassword"){
            NewPassword(navController)
        }


        //home
        composable(route= "home"){
            HomeScreen(navController)
        }




    }

}