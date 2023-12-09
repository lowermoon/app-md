package com.jejetrue.skillshiftapp.data.repository

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