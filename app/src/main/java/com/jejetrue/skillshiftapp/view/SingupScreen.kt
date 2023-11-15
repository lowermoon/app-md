package com.jejetrue.skillshiftapp.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jejetrue.skillshiftapp.R
import com.jejetrue.skillshiftapp.components.ButtonComponent
import com.jejetrue.skillshiftapp.components.CheckboxComponent
import com.jejetrue.skillshiftapp.components.ClickableLogin
import com.jejetrue.skillshiftapp.components.DividerTextComponent
import com.jejetrue.skillshiftapp.components.HeadingTextComponent
import com.jejetrue.skillshiftapp.components.MyTextField
import com.jejetrue.skillshiftapp.components.NormalTextComponent
import com.jejetrue.skillshiftapp.components.PasswordTextField
import com.jejetrue.skillshiftapp.ui.theme.Black
import com.jejetrue.skillshiftapp.ui.theme.Rose600


@Composable
fun SingupScreen() {
    Surface(modifier = Modifier
        .fillMaxSize()
        .background(color = Color.White)
        .padding(28.dp)) {
        Column {
            NormalTextComponent(value = "Hey there,")
            HeadingTextComponent(value = "Create an Account")
            Spacer(modifier = Modifier.height(20.dp))
            MyTextField(labelValue = "Fullname", painterResource = painterResource(id = R.drawable.ic_profile))
            Spacer(modifier = Modifier.height(20.dp))
            MyTextField(labelValue = "Username", painterResource = painterResource(id = R.drawable.ic_profile))
            Spacer(modifier = Modifier.height(10.dp))
            MyTextField(labelValue = "Email", painterResource = painterResource(id = R.drawable.ic_email))
            Spacer(modifier = Modifier.height(10.dp))
            PasswordTextField(labelValue = "Password", painterResource = painterResource(id = R.drawable.ic_lock))
            Spacer(modifier = Modifier.height(50.dp))

            Row {
                Button(onClick = { },) {
                    Box (modifier = Modifier
                        .background(
                            brush = Brush.horizontalGradient(
                                listOf(
                                    Black, Rose600
                                )
                            ),
                            shape = RoundedCornerShape(50.dp)
                        ),
                        contentAlignment = Alignment.Center){
                        Text(text = "For User")

                    }
                    
                }
                Button(onClick = { }) {
                    Text(text = "For Freelancer")
                    
                }


            }


            Spacer(modifier = Modifier.height(20.dp))
            DividerTextComponent()
            ClickableLogin(tryingToLogin = true,onTextSelected = {

            })





        }

    }

}

@Preview
@Composable
fun DefaultPreviewOfSignUpScreen() {
    SingupScreen()

}