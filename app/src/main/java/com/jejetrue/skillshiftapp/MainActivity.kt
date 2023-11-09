package com.jejetrue.skillshiftapp

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.jejetrue.skillshiftapp.data.api.response.LoginResponse
import com.jejetrue.skillshiftapp.data.api.retrofit.ApiConfig
import com.jejetrue.skillshiftapp.ui.theme.SkillShiftAppTheme
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SkillShiftAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
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

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Row {
        Column {
            Text(text = "Hallo $name", modifier = modifier)
            Button(onClick = {
                login(
                    username = "jeje",
                    password = "jeje"
                )
            }) {
                Text(text = "Login")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SkillShiftAppTheme {
        Greeting("Android")
    }
}