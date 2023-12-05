package com.jejetrue.skillshiftapp.view.home

import android.util.Log
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import com.jejetrue.skillshiftapp.data.datastore.UserStore
import com.jejetrue.skillshiftapp.data.response.getProfile
import com.jejetrue.skillshiftapp.data.retrofit.ExecApi

@Composable
fun HomeScreen(navController: NavHostController,modifier: Modifier = Modifier) {
    val context = LocalContext.current
    val store = UserStore(context)
    val token = store.getAccessToken.collectAsState(initial = "")
    var prosessProfile by remember {
        mutableStateOf(false)
    }
    Button(onClick = {
        prosessProfile = true
    }) {
        Text(text = "GassKeun !")
    }
    if ( prosessProfile ) {
        ExecApi {
            val ress = getProfile(token.value)
            Log.d("ZAW", "RESPONSE : ${ress}")
        }
    }
}