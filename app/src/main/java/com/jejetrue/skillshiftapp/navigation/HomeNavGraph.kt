package com.jejetrue.skillshiftapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.jejetrue.skillshiftapp.view.main.BottomBarScreen
import com.jejetrue.skillshiftapp.view.main.home.HomeScreen
import com.jejetrue.skillshiftapp.view.main.ProjectScreen
import com.jejetrue.skillshiftapp.view.main.profile.ProfileScreen

@Composable
fun HomeNavGraph(navController: NavHostController){
    NavHost(
        navController = navController,
        route = Graph.HOME,
        startDestination = BottomBarScreen.Home.route
    ){
        composable(route = BottomBarScreen.Home.route){
            HomeScreen(
                name = BottomBarScreen.Home.route,
                onClick = {}
            )
        }

        composable(route = BottomBarScreen.Project.route){
            ProjectScreen(
                name = BottomBarScreen.Project.route,
                onClick = {}
            )
        }

        composable(route = BottomBarScreen.Profile.route) {
            ProfileScreen(
                onClick = { }
            )
        }



    }

}