package com.jejetrue.skillshiftapp.view.login.login

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.ImageLoader
import coil.compose.AsyncImage
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import coil.compose.rememberImagePainter
import coil.imageLoader
import coil.request.Disposable
import coil.request.ImageRequest
import com.jejetrue.skillshiftapp.R
import com.jejetrue.skillshiftapp.components.ClickableLogin
import com.jejetrue.skillshiftapp.components.DividerTextComponent
import com.jejetrue.skillshiftapp.components.ForgotPassword
import com.jejetrue.skillshiftapp.components.FullWidthButton
import com.jejetrue.skillshiftapp.components.HeadingTextComponent
import com.jejetrue.skillshiftapp.components.NormalTextComponent
import com.jejetrue.skillshiftapp.components.NormalTextField
import com.jejetrue.skillshiftapp.components.PasswordTextField
import com.jejetrue.skillshiftapp.data.datastore.UserStore
import com.jejetrue.skillshiftapp.data.payload.dataLogin
import com.jejetrue.skillshiftapp.data.response.signin
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

@OptIn(DelicateCoroutinesApi::class)
@Composable
fun LoginScreen(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    val store = UserStore(context)
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    val tokenText = store.getAccessToken.collectAsState(initial = "")

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
        NormalTextField(labelValue = "Username", painterResource = painterResource(id = R.drawable.ic_email), onValueChange = {
            username = it
        }, input = username)
        Spacer(modifier = Modifier.height(10.dp))
        PasswordTextField(labelValue = "Password", painterResource = painterResource(id = R.drawable.ic_lock), onValueChange = {
            password = it
        }, input = password)
        Spacer(modifier = Modifier.height(30.dp))
        ForgotPassword()
        Spacer(modifier = Modifier.height(30.dp))
        FullWidthButton(text = "Login", onClick = {
            GlobalScope.launch {
                try {
                    val tokenLogin = signin(dataLogin(username, password))
                    store.saveToken(tokenLogin)
                }catch (e: Exception) {
                    Log.d("ZAW", e.message.toString())
                }
            }
        })


        Spacer(modifier = Modifier.height(20.dp))
        DividerTextComponent()
        ClickableLogin(tryingToLogin = false,onTextSelected = {
            navController.navigate("register")
        })
    }

    if ( tokenText.value !== "") {
        if ( tokenText.value !== "null" ) {
            navController.navigate("home")
        }
    }
}

@Preview
@Composable
fun LoginScreenPreview() {
    
}