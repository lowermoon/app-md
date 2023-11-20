package com.jejetrue.skillshiftapp.view.register

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
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