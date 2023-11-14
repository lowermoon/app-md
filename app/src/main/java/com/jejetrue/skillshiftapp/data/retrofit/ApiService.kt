package com.jejetrue.skillshiftapp.data.retrofit

import com.jejetrue.skillshiftapp.data.response.LoginResponse
import org.json.JSONObject
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {

    @POST("login")
    fun login(
        @Body dataLogin: JSONObject
    ) : Call<LoginResponse>
}