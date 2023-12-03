package com.jejetrue.skillshiftapp.view.register.otp

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.jejetrue.skillshiftapp.components.OtpTextField
import com.jejetrue.skillshiftapp.ui.theme.SkillShiftAppTheme


@Composable
fun VerifyAccount(
    email: String,
    modifier: Modifier = Modifier,
    navigateToLogin: () -> Unit
) {
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
        OtpTextField(email, navigateToLogin = navigateToLogin)
    }
}

@Preview
@Composable
fun PagePreview() {
    SkillShiftAppTheme {
//        VerifyAccount("bahardev1101@gmail.com")
    }
}