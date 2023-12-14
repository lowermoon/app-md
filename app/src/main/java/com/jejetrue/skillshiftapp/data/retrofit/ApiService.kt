package com.jejetrue.skillshiftapp.data.retrofit

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import com.jejetrue.skillshiftapp.data.response.LoginResponse
import com.jejetrue.skillshiftapp.data.response.ProfileResponse
import com.jejetrue.skillshiftapp.data.response.RegisterResponse
import com.jejetrue.skillshiftapp.data.response.VerifyResponse
import com.jejetrue.skillshiftapp.ui.components.LoadingDialog
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part

interface ApiService {

    @POST("loginFreelancer")
    fun login(
        @Body body: RequestBody
    ) : Call<LoginResponse>

    @POST("register")
    fun register(
        @Body body: RequestBody
    ) : Call<RegisterResponse>

    @POST("verifyUser")
    fun verifyUser(
        @Header("Cookie") token: String,
        @Body body: RequestBody
    ): Call<VerifyResponse>

    @GET("profile")
    fun getProfile(
        @Header("Cookie") token: String
    ): Call<ProfileResponse>

    @POST("profile/uploadphoto")
    @Multipart
    fun chengeProfileImage(
        @Header("Cookie") token: String,
        @Part image: MultipartBody.Part
    ): Call<ProfileResponse>
}

@OptIn(DelicateCoroutinesApi::class)
@Composable
fun ExecApi(
    action: () -> Unit
) {
    LoadingDialog()
    LaunchedEffect(true) {
        CoroutineScope(Dispatchers.Default).launch {
            action()
        }
    }
}