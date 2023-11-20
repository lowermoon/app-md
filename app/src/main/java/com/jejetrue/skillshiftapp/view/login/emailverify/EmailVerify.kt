package com.jejetrue.skillshiftapp.view.login.emailverify

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jejetrue.skillshiftapp.R
import com.jejetrue.skillshiftapp.components.EmailTextField
import com.jejetrue.skillshiftapp.components.FullWidthButton
import com.jejetrue.skillshiftapp.ui.theme.SkillShiftAppTheme

@Composable
fun EmailVerify(modifier: Modifier = Modifier) {

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ) {

        Text(
            text = "Enter your email and we'll send you a otp",
            modifier = Modifier,
            style = TextStyle(
                fontSize = 18.sp,
                fontWeight = FontWeight.Normal

            )
        )
        Spacer(modifier = Modifier.height(20.dp))
        EmailTextField(labelValue = "Email", painterResource = painterResource(id = R.drawable.ic_email))
        Spacer(modifier = Modifier.height(20.dp))
        FullWidthButton(text = "Send") {

        }

    }
    
}

@Preview
@Composable
fun EmailVerifyPreview() {
    SkillShiftAppTheme {
        EmailVerify()
    }

}