package com.jejetrue.skillshiftapp.data.repository

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.platform.LocalContext
import com.jejetrue.skillshiftapp.data.datastore.UserStore
import com.jejetrue.skillshiftapp.model.User

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

    fun getToken(): String {
        return user.token
    }

    fun setToken(token: String) {
        user = User(token)
    }
}

@Composable
fun getToken(): String {
    val context = LocalContext.current
    val store = UserStore(context)
    val token = store.getAccessToken.collectAsState(initial = "")
    return token.value
}