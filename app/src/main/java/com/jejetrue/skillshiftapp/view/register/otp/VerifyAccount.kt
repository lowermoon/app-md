package com.jejetrue.skillshiftapp.view.register.otp

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.jejetrue.skillshiftapp.components.OtpTextField
import com.jejetrue.skillshiftapp.ui.theme.SkillShiftAppTheme


@Composable
fun VerifyAccount(modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ){
        OtpTextField()
    }
}

@Preview
@Composable
fun PagePreview() {
    SkillShiftAppTheme {
        VerifyAccount()
    }
}