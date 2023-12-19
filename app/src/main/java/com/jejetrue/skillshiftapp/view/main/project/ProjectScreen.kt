package com.jejetrue.skillshiftapp.view.main.project

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Cancel
import androidx.compose.material.icons.filled.Error
import androidx.compose.material.icons.filled.Help
import androidx.compose.material.icons.filled.MonetizationOn
import androidx.compose.material.icons.filled.PersonPin
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jejetrue.skillshiftapp.R
import com.jejetrue.skillshiftapp.ui.theme.BorderBlue
import com.jejetrue.skillshiftapp.ui.theme.DarkBlue2
import com.jejetrue.skillshiftapp.ui.theme.DarkBlueBG

@Composable
fun ProjectScreen(){

    Box(
        modifier = Modifier.fillMaxSize(),
    ) {
        Column(modifier = Modifier.padding(15.dp)) {
            //jika project kosong maka akan menapilkan di bawah ini
            ProjectKosong()
            Spacer(modifier = Modifier.height(10.dp))
            DaftarPenawaran()
            Spacer(modifier = Modifier.height(10.dp))
            //LazyColumn
            ProjectItem()

            //jika ada project maka menampilkan list(LazyColumn)
            //ProjectAktif()
        }
    }

}

//jika tidak terdapat project yang aktif, maka akan menampilkan bagian ini
@Composable
fun ProjectKosong() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .border(1.dp, BorderBlue, shape = RoundedCornerShape(8.dp))
            .background(
                color = DarkBlueBG,
                shape = RoundedCornerShape(8.dp)
            ),

    )

    {
        Column(modifier = Modifier.padding(15.dp)) {
            Text(text = "Kamu belum punya proyek aktif", color = Color.White)
            Spacer(modifier = Modifier.height(15.dp))

            Row {
                Icon(imageVector = Icons.Default.Help, contentDescription = "", tint = Color.Blue)
                Spacer(Modifier.size(ButtonDefaults.IconSpacing))
                Text(text = "Anda bisa memulai proyek baru anda dengan mencari dan mengambil daftar proyek yang ada.", color = Color.White, fontSize = 10.sp)
            }
            Spacer(modifier = Modifier.height(5.dp))

            Row {
                Icon(imageVector = Icons.Default.Error, contentDescription = "", tint = Color.Red)
                Spacer(Modifier.size(ButtonDefaults.IconSpacing))
                Text(text = "Anda perlu menunggu proyek yang anda tawarkan hingga di Approve oleh pihak User!", color = Color.White, fontSize = 10.sp)
            }
        }

    }
}

@Composable
fun DaftarPenawaran() {
    Column {
        Text(text = "Daftar Penawaran Anda")
        Text(text = "1/10", fontSize = 10.sp)
    }
}

//item project di daftar penawaran(Lazycolumn), disini jika di klik maka akan ke halaman info project
@Composable
fun ProjectItem() {
    Box(modifier = Modifier
        .fillMaxWidth()
        .background(
            color = DarkBlueBG,
            shape = RoundedCornerShape(8.dp)
        ),
    ){
        Column(
            modifier = Modifier.padding(15.dp)
        ) {
            //Judul project
            Text("Mobile Legends", color = Color.White)

            Spacer(modifier = Modifier.height(20.dp))

            //SubJudul
            Text(text = "teks ini berisi subjudul dari project ini", color = Color.White)

            Spacer(modifier = Modifier.height(20.dp))

            Row {
                Icon(imageVector = Icons.Default.MonetizationOn, contentDescription = "", tint = Color.White, modifier = Modifier.size(15.dp))
                Spacer(Modifier.size(ButtonDefaults.IconSpacing))
                Text(text = "Rp.100.000,00-", color = Color.White, fontSize = 9.sp)
            }
        }
    }
    
}


//ketika ada project yang diambil maka akan menapilkan ini
@Composable
fun ProjectAktif() {
    Box (modifier = Modifier
        .fillMaxWidth()
        .background(
            color = DarkBlueBG,
            shape = RoundedCornerShape(8.dp)
        ),
    ){
        Column(modifier = Modifier.padding(15.dp)) {
            //judul
            Text(text = "Mobile Legends")

            Spacer(modifier = Modifier.height(8.dp))

            //subjudul
            Text(text = "Teks ini untuk subjudul pada proyek ini")

            Spacer(modifier = Modifier.height(15.dp))

            //deskripsi
            Box(
                modifier = Modifier
                    .background(
                        color = DarkBlue2,
                        shape = RoundedCornerShape(30.dp)
                    ),
            ) {
                Text(
                    text = "Deskripsi",
                    Modifier.padding(8.dp),
                    color = Color.White,
                    fontSize = 8.sp
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.")

            Spacer(modifier = Modifier.height(8.dp))

            //gambar proyek
            Image(
                painter = painterResource(id = R.drawable.testing),
                contentDescription = "",
                contentScale = ContentScale.Fit,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(15.dp))



            //keterangan(dibuat dan harga)
            Column {
                Box(
                    modifier = Modifier
                        .background(
                            color = DarkBlue2,
                            shape = RoundedCornerShape(30.dp)
                        ),
                ) {
                    Text(
                        text = "Keterangan",
                        Modifier.padding(8.dp),
                        color = Color.White,
                        fontSize = 8.sp
                    )

                }

                Spacer(modifier = Modifier.height(8.dp))

                Row {
                    Icon(imageVector = Icons.Default.MonetizationOn, contentDescription = "", modifier = Modifier.size(15.dp))
                    Spacer(Modifier.size(ButtonDefaults.IconSpacing))
                    Text(text = "Rp.100.000,00-", fontSize = 9.sp)
                }

                Spacer(modifier = Modifier.height(8.dp))

                Row {
                    Icon(imageVector = Icons.Default.PersonPin, contentDescription = "", modifier = Modifier.size(15.dp))
                    Spacer(Modifier.size(ButtonDefaults.IconSpacing))
                    Text(text = "dibuat oleh ZiyadZk", fontSize = 9.sp)
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            //tombol
            Button(onClick = {  }) {
                Icon(imageVector = Icons.Default.Cancel, contentDescription = "")
                Spacer(Modifier.size(ButtonDefaults.IconSpacing))
                Text(text = "batalkan proyek")

            }
        }
    }

    
}




@Preview
@Composable
fun ProjectPreview2() {
    ProjectScreen()
}

