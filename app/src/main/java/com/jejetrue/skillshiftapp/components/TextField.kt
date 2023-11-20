package com.jejetrue.skillshiftapp.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.jejetrue.skillshiftapp.ui.theme.Rose600

//Text Field untuk input data
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NormalTextField(labelValue : String, painterResource : Painter) {
    var text by remember {
        mutableStateOf("")
    }
    OutlinedTextField(
        value = text,
        onValueChange = { text = it },
        label = { Text(labelValue) },
        shape = RoundedCornerShape(35.dp),
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = Rose600,
            focusedLabelColor = Rose600,
            unfocusedBorderColor = Color.Gray,
            unfocusedLabelColor = Color.Gray,
        ),
        keyboardOptions = KeyboardOptions.Default,
        leadingIcon = { Icon(painter = painterResource, contentDescription = "") }


    )

}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EmailTextField(labelValue : String, painterResource : Painter) {
    var email by remember {
        mutableStateOf("")
    }
    OutlinedTextField(
        shape = RoundedCornerShape(50),
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = Rose600,
            focusedLabelColor = Rose600,
            unfocusedBorderColor = Color.Gray,
            unfocusedLabelColor = Color.Gray,
        ),
        value = email,
        onValueChange = {email = it},
        label = { Text(text = labelValue) },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
        leadingIcon = { Icon(painter = painterResource, contentDescription = "") }


    )

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PasswordTextField(labelValue : String, painterResource : Painter) {
    var password by remember {
        mutableStateOf("")
    }
    var passwordVisible by remember {
        mutableStateOf(false)
    }

    OutlinedTextField(
        value = password,
        shape = RoundedCornerShape(35.dp),
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = Rose600,
            focusedLabelColor = Rose600,
            unfocusedBorderColor = Color.Gray,
            unfocusedLabelColor = Color.Gray,
        ),
        onValueChange = {password = it},
        label = { Text(text = labelValue) },
        keyboardOptions = KeyboardOptions(keyboardType =  KeyboardType.Password),
        leadingIcon = { Icon(painter = painterResource, contentDescription = "") },
        trailingIcon = {
            val iconImage = if (passwordVisible){
                Icons.Filled.Visibility

            }else{
                Icons.Filled.VisibilityOff
            }

            var description = if (passwordVisible){
                "Hide password"
            }else{
                "Show password"
            }

            IconButton(onClick = { passwordVisible = !passwordVisible }) {
                Icon(imageVector = iconImage, contentDescription = description)

            }
        },
        visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation()

    )
}

@Composable
fun OtpTextField() {
    var otpCode by remember {
        mutableStateOf("")
    }

    BasicTextField(
        value = otpCode,
        onValueChange = { newValue ->
            otpCode = newValue
        },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.NumberPassword
        ),
        decorationBox = {
            Row(
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                repeat(6){index ->
                    val number = when {
                        index >= otpCode.length -> ""
                        else -> otpCode[index].toString()
                    }

                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.spacedBy(6.dp)
                    ) {
                        Text(
                            text = number,
                            style = MaterialTheme.typography.titleLarge,
                        )

                        Box(
                            modifier = Modifier
                                .width(40.dp)
                                .height(2.dp)
                                .background(Color.Black)
                        )
                    }
                }

            }
        }
    )

}

