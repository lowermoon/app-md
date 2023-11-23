package com.jejetrue.skillshiftapp.data.retrofit

import com.jejetrue.skillshiftapp.data.response.LoginResponse
import com.jejetrue.skillshiftapp.data.response.RegisterResponse
import okhttp3.RequestBody
import org.json.JSONObject
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {

    @POST("login")
    fun login(
        @Body dataLogin: String
    ) : Call<LoginResponse>

    @POST("register")
    fun register(
        @Body body: RequestBody
    ) : Call<RegisterResponse>
}