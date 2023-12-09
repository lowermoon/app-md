package com.jejetrue.skillshiftapp.view.login.newpass

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.jejetrue.skillshiftapp.R
import com.jejetrue.skillshiftapp.components.FullWidthButton
import com.jejetrue.skillshiftapp.components.NormalTextField
import com.jejetrue.skillshiftapp.components.PasswordTextField

@Composable
fun NewPassword(onClick: () -> Unit, ) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ){
        Text(
            text = "Enter your New Password",
            modifier = Modifier,
            style = TextStyle(
                fontSize = 18.sp,
                fontWeight = FontWeight.Normal

            )
        )
        Spacer(modifier = Modifier.height(20.dp))

        PasswordTextField(labelValue = "New Password", painterResource = painterResource(id = R.drawable.ic_lock))

        Spacer(modifier = Modifier.height(20.dp))

        FullWidthButton(
            text = "Submit",
            onClick = {
                onClick()
            }
        )

    }

}