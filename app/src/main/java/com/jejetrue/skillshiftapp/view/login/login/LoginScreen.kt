package com.jejetrue.skillshiftapp.view.login.login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.unit.dp
import com.jejetrue.skillshiftapp.R
import com.jejetrue.skillshiftapp.components.ClickableLogin
import com.jejetrue.skillshiftapp.components.DividerTextComponent
import com.jejetrue.skillshiftapp.components.FullWidthButton
import com.jejetrue.skillshiftapp.components.HeadingTextComponent
import com.jejetrue.skillshiftapp.components.NormalTextComponent
import com.jejetrue.skillshiftapp.components.NormalTextField
import com.jejetrue.skillshiftapp.components.PasswordTextField
import com.jejetrue.skillshiftapp.data.datastore.UserStore
import com.jejetrue.skillshiftapp.data.payload.dataLogin
import com.jejetrue.skillshiftapp.data.response.signin
import com.jejetrue.skillshiftapp.data.retrofit.ExecApi
import com.jejetrue.skillshiftapp.ui.components.ErrorDialog
import kotlinx.coroutines.DelicateCoroutinesApi


@OptIn(DelicateCoroutinesApi::class)
@Composable
fun LoginScreen(
    onLoginClick: () -> Unit,
    onSignUpClick: () -> Unit,
    onForgotClick: () -> Unit
) {
    val context = LocalContext.current
    val store = UserStore(context)

    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

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
        NormalTextField(labelValue = "Username", painterResource = painterResource(id = R.drawable.ic_profile), onValueChange = {
            username = it
        }, input = username)
        Spacer(modifier = Modifier.height(10.dp))
        PasswordTextField(labelValue = "Password", painterResource = painterResource(id = R.drawable.ic_lock), onValueChange = {
            password = it
        }, input = password)
        Spacer(modifier = Modifier.height(30.dp))
        //forgot password
        ClickableText(
            text = AnnotatedString("Forgot your password?"),
            onClick = { offset ->
                onForgotClick()
            }
        )
        Spacer(modifier = Modifier.height(30.dp))

        //button login
        var fetchLogin by remember { mutableStateOf(false) }
        var tokenLogin by remember { mutableStateOf("") }
        var error by remember { mutableStateOf(false) }
        val errorMessage by remember { mutableStateOf("Username/Password Salah !") }
        FullWidthButton(
            text = "Login",
            onClick = {
                fetchLogin = true
        })
        if (fetchLogin) {
            ExecApi {
                error = false
                val ress = signin(dataLogin(username, password))
                tokenLogin = ress?.result?.token.toString()
                if ( ress == null ) {
                    error = true
                }
            }
            LaunchedEffect(tokenLogin) {
                if (tokenLogin !== "") {
                    store.saveToken(token = tokenLogin)
                    onLoginClick()
                }
            }
        }
        if ( error ) {
            ErrorDialog(message = errorMessage)
        }
        Spacer(modifier = Modifier.height(20.dp))
        DividerTextComponent()
        ClickableLogin(tryingToLogin = false,onTextSelected = {
            onSignUpClick()
        })
    }

}


