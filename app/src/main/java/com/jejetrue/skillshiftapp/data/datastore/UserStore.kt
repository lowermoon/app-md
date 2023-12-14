package com.jejetrue.skillshiftapp.data.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
class UserStore (private val context: Context) {
    companion object {
        private val Context.datastore: DataStore<Preferences> by preferencesDataStore("userToken")
        private val USER_TOKEN_KEY = stringPreferencesKey("user_token")
    }
    val getAccessToken: Flow<String> = context.datastore.data.map { preferences ->
        preferences[USER_TOKEN_KEY]?: ""
    }
    suspend fun saveToken(token: String) {
        context.datastore.edit {
            it[USER_TOKEN_KEY] = token
        }
    }
}