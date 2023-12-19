package com.jejetrue.skillshiftapp.data.repository

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.platform.LocalContext
import com.jejetrue.skillshiftapp.data.datastore.UserStore
import com.jejetrue.skillshiftapp.model.User
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class UserRepository {

    private var user: User = User("")

    companion object {
        @Volatile
        private var instance: UserRepository? = null
        fun getInstance(): UserRepository = instance ?: synchronized(this) {
            UserRepository().apply {
                instance = this
            }
        }
    }
}

@Composable
fun getToken(): String {
    val context = LocalContext.current
    val store = UserStore(context)
    val token = store.getAccessToken.collectAsState(initial = "")
    return token.value
}

@OptIn(DelicateCoroutinesApi::class)
@Composable
fun removeToken() {
    val context = LocalContext.current
    val store = UserStore(context)
    LaunchedEffect(true) {
        GlobalScope.launch {
            store.removeToken()
        }
    }
}