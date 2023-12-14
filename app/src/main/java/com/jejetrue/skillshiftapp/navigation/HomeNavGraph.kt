package com.jejetrue.skillshiftapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.jejetrue.skillshiftapp.data.datastore.UserStore
import com.jejetrue.skillshiftapp.view.login.emailverify.EmailVerify
import com.jejetrue.skillshiftapp.view.login.login.LoginScreen
import com.jejetrue.skillshiftapp.view.login.newpass.NewPassword
import com.jejetrue.skillshiftapp.view.login.otp.OtpVerify
import com.jejetrue.skillshiftapp.view.main.BottomBarScreen
import com.jejetrue.skillshiftapp.view.main.ProjectScreen
import com.jejetrue.skillshiftapp.view.main.home.HomeScreen
import com.jejetrue.skillshiftapp.view.main.profile.ProfileScreen
import com.jejetrue.skillshiftapp.view.register.otp.VerifyAccount
import com.jejetrue.skillshiftapp.view.register.signup.SignupScreen

@Composable
fun HomeNavGraph(navController: NavHostController){
    val context = LocalContext.current
    val store = UserStore(context)
    val tokenText = store.getAccessToken.collectAsState(initial = "")
    val RouteHome = if (tokenText.value == "" || tokenText.value == "null") AuthScreen.Login.route else BottomBarScreen.Home.route

    NavHost(
        navController = navController,
        route = Graph.HOME,
        startDestination = RouteHome
    ){
        composable(route = BottomBarScreen.Home.route){
            HomeScreen()
        }

        composable(route = BottomBarScreen.Project.route){
            ProjectScreen(
                name = BottomBarScreen.Project.route,
                onClick = {}
            )
        }

        composable(route = BottomBarScreen.Profile.route) {
            ProfileScreen(
            )
        }

        //LOGIN
        composable(route = AuthScreen.Login.route){
            LoginScreen(
                onLoginClick = {
                    navController.popBackStack()
                    navController.navigate(Graph.HOME){
                        popUpTo(Graph.HOME){
                            inclusive = true
                        }
                    }
                },
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
            })
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
                    navController.navigate((AuthScreen.Login.route)){
                        popUpTo(AuthScreen.Login.route) {
                            inclusive = true
                        }
                    }
                }
            )
        }
    }

}