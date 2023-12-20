package com.jejetrue.skillshiftapp.view.main

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.jejetrue.skillshiftapp.view.main.project.KategoriProject

@Composable
fun ProjectItem(
    title: String,
    subTitle: String
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentSize(),
        elevation = CardDefaults.cardElevation(10.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp)
        ) {
            //Judul project
            Text(title, fontWeight = FontWeight.Bold )
            Spacer(modifier = Modifier.height(8.dp))

            //kategori
            Row(horizontalArrangement = Arrangement.spacedBy(5.dp)) {
                KategoriProject("Games")
                KategoriProject("mobile legends")
            }

            Spacer(modifier = Modifier.height(20.dp))

            //SubJudul
            Text(text = subTitle)


        }
    }

}