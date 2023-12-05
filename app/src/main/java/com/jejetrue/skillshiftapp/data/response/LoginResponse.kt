package com.jejetrue.skillshiftapp.data.response

import com.google.gson.Gson
import com.google.gson.annotations.SerializedName
import com.jejetrue.skillshiftapp.data.payload.dataLogin
import com.jejetrue.skillshiftapp.data.retrofit.ApiConfig
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody.Companion.toRequestBody

data class LoginResponse(
    @field:SerializedName("role")
    val role: String? = null,

    @field:SerializedName("level")
    val level: Int? = null,

    @field:SerializedName("EXP")
    val eXP: Int? = null,

    @field:SerializedName("email")
    val email: String? = null,

    @field:SerializedName("username")
    val username: String? = null,

    @field:SerializedName("token")
    val token: String? = null
)

fun signin(dataLogin: dataLogin): String {
    val service = ApiConfig.getApiService()
    val payload = Gson().toJson(dataLogin)
    val requestBody = payload.toRequestBody("application/json".toMediaTypeOrNull())
    val response = service.login(requestBody).execute()
    val token = response.body()?.token
    return token.toString()
}
