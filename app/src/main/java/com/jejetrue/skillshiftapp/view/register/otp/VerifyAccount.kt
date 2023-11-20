package com.jejetrue.skillshiftapp.view.register.otp

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.jejetrue.skillshiftapp.components.OtpTextField
import com.jejetrue.skillshiftapp.ui.theme.SkillShiftAppTheme


@Composable
fun VerifyAccount(modifier: Modifier = Modifier) {
    OtpTextField()

    
}

@Preview
@Composable
fun PagePreview() {
    SkillShiftAppTheme {
        VerifyAccount()
    }

}