package com.jejetrue.skillshiftapp.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog

@Composable
fun LoadingDialog() {
    Dialog(
        onDismissRequest = {

        }
    ) {
        DialogContainer(
            title = "Harap Tunggu !",
            content = {
                CircularProgressIndicator(
                    color = MaterialTheme.colorScheme.inversePrimary
                )
            }
        )
    }
}

@Composable
fun ErrorDialog(message: String){
    var close by remember { mutableStateOf(false) }
    if ( !close ) {
        Dialog(
            onDismissRequest = {}
        ) {
            DialogContainer(
                title = "Error",
                content = {
                    Text(text = message)
                }
            )
            Button(onClick = { close = true }) {
                Text(text = "Close")
            }
        }
    }
}

@Composable
fun DialogContainer(title: String, content: @Composable () -> Unit) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(10.dp))
            .background(MaterialTheme.colorScheme.primary)
            .padding(24.dp)
    ) {
        Text(
            text = title,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.padding(12.dp))
        content()
    }
}


@Composable
@Preview(showSystemUi = true, showBackground = true)
fun PreViewDialog() {
    LoadingDialog()
}