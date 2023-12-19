package com.jejetrue.skillshiftapp.components

import android.util.Log
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

//judul
@Composable
fun NormalTextComponent(value : String) {
    Text(
        text = value,
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 40.dp),
        style = TextStyle(
            fontSize = 24.sp,
            fontWeight = FontWeight.Normal

        )
        , textAlign = TextAlign.Center
    )
}

@Composable
fun HeadingTextComponent(value : String) {
    Text(
        text = value,
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(),
        style = TextStyle(
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold

        )
        , textAlign = TextAlign.Center
    )
}
//Judul


//Text Field untuk input data

//tambahan aksesoris garis pemisah
@Composable
fun DividerTextComponent() {
    Row(modifier = Modifier
        .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
        ) {
        Divider(modifier = Modifier
            .fillMaxWidth()
            .weight(1f),
            color = Color.Gray,
            thickness = 1.dp
        )

        Text(modifier = Modifier.padding(8.dp),text = " or ", fontSize = 18.sp, color = Color.Gray)

        Divider(modifier = Modifier
            .fillMaxWidth()
            .weight(1f),
            color = Color.Gray,
            thickness = 1.dp
        )

    }
    
}
//tambahan aksesoris garis pemisah

@Composable
fun ClickableLogin( tryingToLogin : Boolean = true, onTextSelected : (String) -> Unit) {
    val initialText = if (tryingToLogin) "Already have an account? " else "Don't have an account yet?"
    val loginText = if (tryingToLogin)"Login" else " Register"

    val annotatedString = buildAnnotatedString {
        append(initialText)
        withStyle(SpanStyle(MaterialTheme.colorScheme.primary)){
            pushStringAnnotation(tag = loginText, annotation = loginText)
            append(loginText)
        }
    }
    ClickableText(text = annotatedString, onClick = {offset ->
        annotatedString.getStringAnnotations(offset,offset).firstOrNull()?.also { span->
            Log.d("ClickableLogin", "{${span.item}}")

            if ((span.item == loginText)){
                onTextSelected(span.item)
            }
        }
    })
}

@Composable
fun UnderlineTextComponent(value : String) {
    Text(
        text = value,
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 40.dp),
        style = TextStyle(
            fontSize = 16.sp,
            fontWeight = FontWeight.Normal

        ),
        color = Color.Gray
        , textAlign = TextAlign.Center,
        textDecoration = TextDecoration.Underline
    )
}













