package com.jejetrue.skillshiftapp.view.register.otp

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.jejetrue.skillshiftapp.components.OtpTextField


@Composable
fun VerifyAccount(
    email: String,
    tokenRegis: String,
    onClick: () -> Unit, ) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ){
        Text(text = "Code sent to $email")
        Text(
            text = "Enter Verification Code Here",
            fontWeight = FontWeight.Bold,
        )
        Spacer(modifier = Modifier.height(20.dp))

        OtpTextField(
            email = email,
            token = tokenRegis,
            navigation = {
                onClick()
            }
        )



    }

    
}

