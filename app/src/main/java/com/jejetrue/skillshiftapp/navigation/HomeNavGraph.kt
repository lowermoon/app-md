package com.jejetrue.skillshiftapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.jejetrue.skillshiftapp.data.repository.getToken
import com.jejetrue.skillshiftapp.data.repository.removeToken
import com.jejetrue.skillshiftapp.view.login.emailverify.EmailVerify
import com.jejetrue.skillshiftapp.view.login.login.LoginScreen
import com.jejetrue.skillshiftapp.view.login.newpass.NewPassword
import com.jejetrue.skillshiftapp.view.login.otp.OtpVerify
import com.jejetrue.skillshiftapp.view.main.BottomBarScreen
import com.jejetrue.skillshiftapp.view.main.home.HomeScreen
import com.jejetrue.skillshiftapp.view.main.home.InfoTawaran
import com.jejetrue.skillshiftapp.view.main.profile.ProfileScreen
import com.jejetrue.skillshiftapp.view.main.profile.editprofile.EditProfile
import com.jejetrue.skillshiftapp.view.main.profile.faceid.ScanFace
import com.jejetrue.skillshiftapp.view.main.project.ProjectScreen
import com.jejetrue.skillshiftapp.view.register.otp.VerifyAccount
import com.jejetrue.skillshiftapp.view.register.signup.SignupScreen


sealed class PrjectGraph(
    val route: String
) {
    object DetailProject: PrjectGraph("detail/{id}") {
        fun createRoute( id: String ) = "detail/${id}"
    }
}

@Composable
fun HomeNavGraph(navController: NavHostController){
    val tokenText = getToken()
    var RouteHome = if (tokenText == "" || tokenText == "null") AuthScreen.Login.route else BottomBarScreen.Home.route

    NavHost(
        navController = navController,
        route = Graph.HOME,
        startDestination = RouteHome
    ){
        // Home Screen
        composable(route = BottomBarScreen.Home.route){
            HomeScreen(
                navigateToDetail = {
                    navController.navigate(PrjectGraph.DetailProject.createRoute(it))
                }
            )
            //ExampleScreenFaceId()
        }
        composable( // Detail Project
            route = PrjectGraph.DetailProject.route,
            arguments = listOf(navArgument("id"){
                type = NavType.StringType
            })
        ) {
            val id = it.arguments?.getString("id")?: ""
            InfoTawaran(
                id = id,
                backToHome = {
                    navController.navigate(BottomBarScreen.Home.route){
                        popUpTo(BottomBarScreen.Home.route) {
                            inclusive = true
                        }
                    }
                }
            )
        }

        composable(route = BottomBarScreen.Project.route){
            ProjectScreen()
        }


        // Profile
        composable(route = BottomBarScreen.Profile.route) {
            ProfileScreen(
                onEditProfileClick = {
                    navController.navigate(ProfileSetting.EditProfile.route)
                },
                onLogout = {
                    removeToken()
                    navController.navigate(AuthScreen.Login.route){
                        popUpTo(AuthScreen.Login.route){
                            inclusive = true
                            RouteHome = AuthScreen.Login.route
                        }
                    }
                },
                onFaceIdClicked = {
                    navController.navigate(ProfileSetting.FaceID.route)
                }
            )
        }
        composable( // profile setting
            route = ProfileSetting.EditProfile.route,
        ) {
            EditProfile {
                navController.navigate(BottomBarScreen.Profile.route)
            }
        }
        composable(
            route = ProfileSetting.FaceID.route
        ){
            ScanFace()
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