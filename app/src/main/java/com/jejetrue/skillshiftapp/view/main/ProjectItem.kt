package com.jejetrue.skillshiftapp.view.main

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MonetizationOn
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jejetrue.skillshiftapp.view.main.project.KategoriProject

@Composable
fun ProjectItem() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .wrapContentSize(),
        elevation = CardDefaults.cardElevation(10.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp)
        ) {
            //Judul project
            Text("Mobile Legends", fontWeight = FontWeight.Bold )
            Spacer(modifier = Modifier.height(8.dp))

            //kategori
            Row(horizontalArrangement = Arrangement.spacedBy(5.dp)) {
                KategoriProject("Games")
                KategoriProject("mobile legends")

            }

            Spacer(modifier = Modifier.height(20.dp))

            //SubJudul
            Text(text = "teks ini berisi subjudul dari project ini")

            Spacer(modifier = Modifier.height(20.dp))

            Row {
                Icon(
                    imageVector = Icons.Default.MonetizationOn,
                    contentDescription = "",
                    modifier = Modifier.size(15.dp)
                )
                Spacer(Modifier.size(ButtonDefaults.IconSpacing))
                Text(text = "Rp.100.000,00-", fontSize = 9.sp)
            }
        }
    }

}