package com.jejetrue.skillshiftapp.screens

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jejetrue.skillshiftapp.R
import com.jejetrue.skillshiftapp.components.ButtonComponent
import com.jejetrue.skillshiftapp.components.ClickableLogin
import com.jejetrue.skillshiftapp.components.DividerTextComponent
import com.jejetrue.skillshiftapp.components.HeadingTextComponent
import com.jejetrue.skillshiftapp.components.MyTextField
import com.jejetrue.skillshiftapp.components.NormalTextComponent
import com.jejetrue.skillshiftapp.components.PasswordTextField
import com.jejetrue.skillshiftapp.components.UnderlineTextComponent
import com.jejetrue.skillshiftapp.data.response.LoginResponse
import com.jejetrue.skillshiftapp.data.retrofit.ApiConfig
import com.jejetrue.skillshiftapp.ui.theme.Black
import com.jejetrue.skillshiftapp.ui.theme.Rose600
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@Composable
fun LoginScreen() {
    Surface(modifier = Modifier
        .fillMaxSize()
        .background(color = Color.White)
        .padding(28.dp)){
        Column {
            NormalTextComponent(value = "Hey there,")
            HeadingTextComponent(value = "Welcome Back")
            Spacer(modifier = Modifier.height(20.dp))
            MyTextField(labelValue = "Email", painterResource = painterResource(id = R.drawable.ic_email))
            Spacer(modifier = Modifier.height(10.dp))
            PasswordTextField(labelValue = "Password", painterResource = painterResource(id = R.drawable.ic_lock))
            Spacer(modifier = Modifier.height(30.dp))
            UnderlineTextComponent(value = "Forgot your password?")
            Spacer(modifier = Modifier.height(50.dp))
            Button(onClick = { login(
                username = "jeje",
                password = "jeje"
            ) },
                modifier = Modifier.fillMaxWidth().heightIn(48.dp),
                contentPadding = PaddingValues(),
                colors = ButtonDefaults.buttonColors(Color.Transparent)) {

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .heightIn(48.dp)
                        .background(
                            brush = Brush.horizontalGradient(
                                listOf(
                                    Black, Rose600
                                )
                            ),
                            shape = RoundedCornerShape(50.dp)
                        ),
                    contentAlignment = Alignment.Center
                ){
                    Text(text = "Login", fontSize = 18.sp, fontWeight = FontWeight.Bold)

                }

            }

            Spacer(modifier = Modifier.height(20.dp))
            DividerTextComponent()
            ClickableLogin(tryingToLogin = false,onTextSelected = {})
        }

    }

}

@Composable
fun showToast( text: String ) {
    Toast.makeText(LocalContext.current, text, Toast.LENGTH_LONG).show()
}

fun login(username: String, password: String) {
    val dataLogin = JSONObject("{usernaem: '$username', password: '$password'}")
    val client = ApiConfig.getApiService().login(dataLogin)
    client.enqueue(object: Callback<LoginResponse>{
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
    LoginScreen()
    
}