package com.jejetrue.skillshiftapp.view.login.login

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.jejetrue.skillshiftapp.R
import com.jejetrue.skillshiftapp.components.ClickableLogin
import com.jejetrue.skillshiftapp.components.DividerTextComponent
import com.jejetrue.skillshiftapp.components.EmailTextField
import com.jejetrue.skillshiftapp.components.ForgotPassword
import com.jejetrue.skillshiftapp.components.FullWidthButton
import com.jejetrue.skillshiftapp.components.HeadingTextComponent
import com.jejetrue.skillshiftapp.components.NormalTextComponent
import com.jejetrue.skillshiftapp.components.PasswordTextField
import com.jejetrue.skillshiftapp.data.response.LoginResponse
import com.jejetrue.skillshiftapp.data.retrofit.ApiConfig
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@Composable
fun LoginScreen(navController: NavHostController, modifier: Modifier = Modifier,) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        NormalTextComponent(value = "Hey there,")
        HeadingTextComponent(value = "Welcome Back")
        Spacer(modifier = Modifier.height(20.dp))
        EmailTextField(labelValue = "Email", painterResource = painterResource(id = R.drawable.ic_email))
        Spacer(modifier = Modifier.height(10.dp))
        PasswordTextField(labelValue = "Password", painterResource = painterResource(id = R.drawable.ic_lock))
        Spacer(modifier = Modifier.height(30.dp))
        ForgotPassword()
        Spacer(modifier = Modifier.height(30.dp))
        FullWidthButton(text = "Login", onClick = {
            login("jeje","jeje")
            navController.navigate("home")
        })


        Spacer(modifier = Modifier.height(20.dp))
        DividerTextComponent()
        ClickableLogin(tryingToLogin = false,onTextSelected = {
            navController.navigate("register")
        })
    }

}

fun login(username: String, password: String) {
    val dataLogin = JSONObject("{usernaem: '$username', password: '$password'}")
    val client = ApiConfig.getApiService().login(dataLogin)
    client.enqueue(object: Callback<LoginResponse> {
        override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
            val responseBody = response.body()
            Log.d("ZAW", "Response : " + responseBody?.data.toString())
        }

        override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
            Log.d("ZAW", "Error : " + t.message.toString())
        }
    })
}

@Preview
@Composable
fun LoginScreenPreview() {
    
}