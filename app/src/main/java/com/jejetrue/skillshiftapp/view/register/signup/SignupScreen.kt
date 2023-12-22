package com.jejetrue.skillshiftapp.view.register.signup

import android.util.Log
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.jejetrue.skillshiftapp.R
import com.jejetrue.skillshiftapp.components.ClickableLogin
import com.jejetrue.skillshiftapp.components.DividerTextComponent
import com.jejetrue.skillshiftapp.components.EmailTextField
import com.jejetrue.skillshiftapp.components.HeadingTextComponent
import com.jejetrue.skillshiftapp.components.NormalTextComponent
import com.jejetrue.skillshiftapp.components.NormalTextField
import com.jejetrue.skillshiftapp.components.PasswordTextField
import com.jejetrue.skillshiftapp.components.SideButtons
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.tooling.preview.Preview
import com.jejetrue.skillshiftapp.components.FullWidthButton
import com.jejetrue.skillshiftapp.data.payload.dataRegister
import com.jejetrue.skillshiftapp.data.response.register
import com.jejetrue.skillshiftapp.ui.theme.SkillShiftAppTheme
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


@Composable
fun SignupScreen(
    onSignUpClick: (String,String)  -> Unit,
    onLoginClick: () -> Unit,

)
{
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {

        NormalTextComponent(value = "Hey there,")
        HeadingTextComponent(value = "Create an Account")
        Spacer(modifier = Modifier.height(20.dp))

       InputForm(onSignUpClick)

        Spacer(modifier = Modifier.height(20.dp))
        DividerTextComponent()
        ClickableLogin(tryingToLogin = true,onTextSelected = {
            onLoginClick()

        })
    }
}

@OptIn(DelicateCoroutinesApi::class)
@Composable
fun InputForm(
    onSignUpClick: (String,String)  -> Unit,
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPasswrod by remember { mutableStateOf("") }
    var fullName by remember { mutableStateOf("") }
    var username by remember { mutableStateOf("") }
    var token by remember { mutableStateOf("") }
    var register by remember { mutableStateOf(false) }

    //Text Feild Input
    NormalTextField(labelValue = "Fullname", painterResource = painterResource(id = R.drawable.ic_profile), onValueChange = {
        fullName = it
    }, input = fullName)
    Spacer(modifier = Modifier.height(10.dp))
    NormalTextField(labelValue = "Username", painterResource = painterResource(id = R.drawable.ic_profile), onValueChange = {
        username = it
    }, input = username)
    Spacer(modifier = Modifier.height(10.dp))
    EmailTextField(labelValue = "Email", painterResource = painterResource(id = R.drawable.ic_email), onValueChange = {
        email = it
    }, input = email)
    Spacer(modifier = Modifier.height(10.dp))
    PasswordTextField(labelValue = "Password", painterResource = painterResource(id = R.drawable.ic_lock), onValueChange = {
        password = it
    }, input = password)
    Spacer(modifier = Modifier.height(10.dp))
    PasswordTextField(labelValue = "Confirm Password", painterResource = painterResource(id = R.drawable.ic_lock), onValueChange = {
        confirmPasswrod = it
    }, input = confirmPasswrod)
    Spacer(modifier = Modifier.height(30.dp))


    // Action Button
//    var data: dataRegister
//    SideButtons(leftButtonText = "User", rightButtonText = "Freelancer", leftButtonClick = {
//        data = dataRegister("consumer", fullName, email, username, password, confirmPasswrod)
//        GlobalScope.launch {
//            try {
//                token = register(data = data)
//                register = true
//                Log.d("ZAW", "$token")
//            }catch (e: Exception) {
//                Log.e("ZAW", "Error : " + e.message.toString())
//            }
//        }
//    }, rightButtonClick = {
//        data = dataRegister("freelancer", fullName, email, username, password, confirmPasswrod)
//        GlobalScope.launch {
//            try {
//                token = register(data = data)
//                register = true
//                Log.d("ZAW", "$token")
//            }catch (e: Exception) {
//                Log.e("ZAW", "Error : " + e.message.toString())
//            }
//        }
//    })
    
    // Action Button
    var data: dataRegister
    FullWidthButton(
        text = "Daftar",
        onClick = {data = dataRegister("freelancer", fullName, email, username, password, confirmPasswrod)
            GlobalScope.launch {
                try {
                    token = register(data = data)
                    register = true
                    Log.d("ZAW", "$token")
                }catch (e: Exception) {
                    Log.e("ZAW", "Error : " + e.message.toString())
                }
            }
        }
    )
    if (register) {
        onSignUpClick(email, token)
    }
}


