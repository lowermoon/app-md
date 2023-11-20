package com.jejetrue.skillshiftapp.view.register.signup

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


@Composable
fun SignupScreen(navController: NavHostController, modifier: Modifier = Modifier) {
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

        //Text Feild Input
        NormalTextField(labelValue = "Fullname", painterResource = painterResource(id = R.drawable.ic_profile))
        Spacer(modifier = Modifier.height(10.dp))
        NormalTextField(labelValue = "Username", painterResource = painterResource(id = R.drawable.ic_profile))
        Spacer(modifier = Modifier.height(10.dp))
        EmailTextField(labelValue = "Email", painterResource = painterResource(id = R.drawable.ic_email))
        Spacer(modifier = Modifier.height(10.dp))
        PasswordTextField(labelValue = "Password", painterResource = painterResource(id = R.drawable.ic_lock))
        Spacer(modifier = Modifier.height(30.dp))

        SideButtons(leftButtonText = "User", rightButtonText = "Freelancer", leftButtonClick = {}, rightButtonClick = {})


        Spacer(modifier = Modifier.height(20.dp))
        DividerTextComponent()
        ClickableLogin(tryingToLogin = true,onTextSelected = {
            navController.navigate("login")

        })





    }

}

