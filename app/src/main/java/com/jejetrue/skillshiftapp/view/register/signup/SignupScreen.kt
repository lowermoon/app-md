package com.jejetrue.skillshiftapp.view.register.signup

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.jejetrue.skillshiftapp.R
import com.jejetrue.skillshiftapp.components.ClickableLogin
import com.jejetrue.skillshiftapp.components.DividerTextComponent
import com.jejetrue.skillshiftapp.components.EmailTextField
import com.jejetrue.skillshiftapp.components.HeadingTextComponent
import com.jejetrue.skillshiftapp.components.NormalTextComponent
import com.jejetrue.skillshiftapp.components.NormalTextField
import com.jejetrue.skillshiftapp.components.PasswordTextField
import com.jejetrue.skillshiftapp.components.SideButtons
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import com.jejetrue.skillshiftapp.data.payload.dataLogin
import com.jejetrue.skillshiftapp.data.payload.dataRegister
import com.jejetrue.skillshiftapp.data.response.register
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


@Composable
fun SignupScreen(navController: NavHostController, modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {

        var email by remember { mutableStateOf("") }
        var password by remember { mutableStateOf("") }
        var confirmPasswrod by remember { mutableStateOf("") }
        var fullName by remember { mutableStateOf("") }
        var username by remember { mutableStateOf("") }
        var register by remember { mutableStateOf(false) }

        NormalTextComponent(value = "Hey there,")
        HeadingTextComponent(value = "Create an Account")
        Spacer(modifier = Modifier.height(20.dp))

        //Fullname
        NormalTextField(labelValue = "Fullname", painterResource = painterResource(id = R.drawable.ic_profile), onValueChange = {
            fullName = it
        }, input = fullName)

        Spacer(modifier = Modifier.height(10.dp))

        //Username
        NormalTextField(labelValue = "Username", painterResource = painterResource(id = R.drawable.ic_profile), onValueChange = {
            username = it
        }, input = username)
        Spacer(modifier = Modifier.height(10.dp))

        //Email
        EmailTextField(labelValue = "Email", painterResource = painterResource(id = R.drawable.ic_email), onValueChange = {
            email = it
        }, input = email)
        Spacer(modifier = Modifier.height(10.dp))

        PasswordTextField(labelValue = "Confirm Password", painterResource = painterResource(id = R.drawable.ic_lock), onValueChange = {
            confirmPasswrod = it
        }, input = confirmPasswrod)
        Spacer(modifier = Modifier.height(30.dp))

        SideButtons(leftButtonText = "User", rightButtonText = "Freelancer",
            //button user
            leftButtonClick = {
            val data = dataRegister("consumer", fullName, email, username, password, confirmPasswrod)
            GlobalScope.launch {
                try {
                    val token = register(data = data)
                    register = true
                }catch (e: Exception) {
                    Log.d("ZAW", "Error : " + e.message.toString())
                }
            }
        },

            //button freelance
            rightButtonClick = {
            val data = dataRegister("freelance", fullName, email, username, password, confirmPasswrod)
            GlobalScope.launch {
                try {
                    val token = register(data = data)
                    register = true
                }catch (e: Exception) {
                    Log.d("ZAW", "Error : " + e.message.toString())
                }
            }

        })


        Spacer(modifier = Modifier.height(20.dp))
        DividerTextComponent()
        ClickableLogin(tryingToLogin = true,onTextSelected = {
            navController.navigate("login")

        })

        if ( register ) {
            navController.navigate("verifAccount")
        }





    }

}

