package com.jejetrue.skillshiftapp.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun SideButtons(
    leftButtonText: String,
    rightButtonText: String,
    leftButtonClick: () -> Unit,
    rightButtonClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .padding(horizontal = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Button(
            onClick = leftButtonClick,
            modifier = Modifier
                .width(120.dp)
                .height(50.dp),
            shape = RoundedCornerShape(50.dp)
        ) {
            Text(
                text = leftButtonText,
            )
        }
        Spacer(modifier = Modifier.width(12.dp))
        Button(
            onClick = { rightButtonClick },
            modifier = Modifier
                .width(120.dp)
                .height(50.dp),
            shape = RoundedCornerShape(50.dp)
        ) {
            Text(
                text = rightButtonText,
            )
        }
    }
}

@Composable
fun FullWidthButton(
    text: String,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .width(120.dp)
            .height(50.dp),
        shape = RoundedCornerShape(50.dp)
    ) {
        Text(
            text = text,
        )
    }

}