package com.jejetrue.skillshiftapp.navigation

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.jejetrue.skillshiftapp.data.datastore.UserStore
import com.jejetrue.skillshiftapp.view.SkillShiftApp

@Composable
fun RootNavigationGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        route = Graph.ROOT,
        startDestination = Graph.AUTHENTICATION
    ){
        authNavGraph(navController = navController)
        composable(route = Graph.HOME) {
            SkillShiftApp()
        }
    }

    val context = LocalContext.current
    val store = UserStore(context)
    val tokenText = store.getAccessToken.collectAsState(initial = "user_token")
    if ( tokenText.value == "null" ) {
        Log.d("ZAW", (tokenText.value == "null").toString())
        navController.navigate(AuthScreen.Login.route)
    }

}

object Graph {
    const val ROOT = "root_graph"
    const val AUTHENTICATION = "auth_graph"
    const val HOME = "home_graph"
}