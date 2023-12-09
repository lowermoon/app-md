package com.jejetrue.skillshiftapp.view.main.profile

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.jejetrue.skillshiftapp.data.response.ExampleSetProfile
import com.jejetrue.skillshiftapp.ui.theme.SkillShiftAppTheme

@Composable
fun ProfileScreen( onClick: () -> Unit){

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            modifier = Modifier.clickable { onClick() },
            text = "Ini profile",
            fontSize = MaterialTheme.typography.titleMedium.fontSize,
            fontWeight = FontWeight.Bold
        )
    }
    ExampleSetProfile()
}

@Preview
@Composable
fun ProfilePreview() {
    SkillShiftAppTheme {
        ProfileScreen {

        }
    }

}