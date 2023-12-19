package com.jejetrue.skillshiftapp.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.jejetrue.skillshiftapp.view.login.emailverify.EmailVerify
import com.jejetrue.skillshiftapp.view.login.login.LoginScreen
import com.jejetrue.skillshiftapp.view.login.newpass.NewPassword
import com.jejetrue.skillshiftapp.view.login.otp.OtpVerify
import com.jejetrue.skillshiftapp.view.register.otp.VerifyAccount
import com.jejetrue.skillshiftapp.view.register.signup.SignupScreen

fun NavGraphBuilder.authNavGraph(navController: NavHostController) {
    navigation(
        route = Graph.AUTHENTICATION,
        startDestination = AuthScreen.Login.route
    ){

        //LOGIN
        composable(route = AuthScreen.Login.route){
            LoginScreen(
                onLoginClick = {
                    navController.popBackStack()
                    navController.navigate(Graph.HOME)},
                onSignUpClick = {
                    navController.navigate(AuthScreen.SignUp.route)
                },
                onForgotClick = {
                    navController.navigate(AuthScreen.Forgot.route)
                }
            )
        }

        //FORGOT PASSWORD
        composable(route = AuthScreen.EmailVerify.route){
            EmailVerify(
                onClick = {
                    navController.navigate(AuthScreen.OtpVerify.route)
                }
            )

        }

        composable(route = AuthScreen.OtpVerify.route){
            OtpVerify(onClick = {
                navController.navigate(AuthScreen.NewPass.route)
                }
            )
        }

        composable(route = AuthScreen.NewPass.route){
            NewPassword (
                onClick = {
                    navController.navigate(AuthScreen.Login.route)
                }
            )
        }

        //REGISTER
        composable(route = AuthScreen.SignUp.route){
            SignupScreen(
                onSignUpClick = { email, token ->
                    navController.navigate(AuthScreen.VerifyAccount.createRoute(email, token))

                },
                onLoginClick = {
                    navController.navigate(AuthScreen.Login.route)
                }
            )
        }

        composable(
            route = AuthScreen.VerifyAccount.route,
            arguments = listOf(navArgument("email"){
                type = NavType.StringType
            })
        ){
            val email = it.arguments?.getString("email") ?: ""
            val token = it.arguments?.getString("tokenRegis") ?: ""
            VerifyAccount(
                email = email,
                tokenRegis = token,
                onClick = {
                    navController.navigate((AuthScreen.Login.route))
                }
            )
        }
    }
}

sealed class AuthScreen(val route: String) {
    object Login : AuthScreen(route = "LOGIN")
    object SignUp : AuthScreen(route = "SIGN_UP")
    object Forgot : AuthScreen(route = "FORGOT")
    object EmailVerify : AuthScreen("EMAIL")
    object NewPass : AuthScreen("NEW PASSWORD")
    object OtpVerify : AuthScreen("OTP VERIFY")
    object VerifyAccount : AuthScreen("verif/{email}/{tokenRegis}") {
        fun createRoute(email: String, tokenRegis: String) = "verif/$email/$tokenRegis"
    }
}