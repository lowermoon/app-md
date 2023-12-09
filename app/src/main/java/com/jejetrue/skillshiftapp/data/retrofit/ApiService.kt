package com.jejetrue.skillshiftapp.data.retrofit

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.jejetrue.skillshiftapp.data.response.LoginResponse
import com.jejetrue.skillshiftapp.data.response.RegisterResponse
import com.jejetrue.skillshiftapp.data.response.VerifyResponse
import com.jejetrue.skillshiftapp.ui.components.ErrorDialog
import com.jejetrue.skillshiftapp.ui.components.LoadingDialog
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {

    @POST("login")
    fun login(
        @Body body: RequestBody
    ) : Call<LoginResponse>

    @POST("register")
    fun register(
        @Body body: RequestBody
    ) : Call<RegisterResponse>

    @POST("verifyUser")
    fun verifyUser(
        @Body body: RequestBody
    ): Call<VerifyResponse>
}

// Coroutine Function
@OptIn(DelicateCoroutinesApi::class)
@Composable
fun ExecApi(
    withDialog: Boolean = true,
    action: () -> Unit
) {
    var loading by remember { mutableStateOf(true) }
    var error by remember { mutableStateOf(true) }
    var errorText by remember { mutableStateOf("") }

    LaunchedEffect(true) {
        loading = true
        error = false
        GlobalScope.launch {
            try {
                action()
                loading = false
            }catch(e: Exception) {
                error = true
                errorText = e.message.toString()
            }
        }
    }

    if ( loading && withDialog ) {
        LoadingDialog()
        if ( error ) {
            ErrorDialog(message = errorText)
        }
    }
}