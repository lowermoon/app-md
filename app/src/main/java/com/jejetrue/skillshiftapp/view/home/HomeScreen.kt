package com.jejetrue.skillshiftapp.view.home

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import com.jejetrue.skillshiftapp.data.datastore.UserStore


@Composable
fun HomeScreen(navController: NavHostController,modifier: Modifier = Modifier) {
    val context = LocalContext.current
    val store = UserStore(context)
    val token = store.getAccessToken.collectAsState(initial = "")
    Button(onClick = { navController.navigate("profile") }) {
        Text(text = "Pindah ke profile!")
    }
}