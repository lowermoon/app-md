package com.jejetrue.skillshiftapp.view.main.project

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Cancel
import androidx.compose.material.icons.filled.MonetizationOn
import androidx.compose.material.icons.filled.PersonPin
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jejetrue.skillshiftapp.R
import com.jejetrue.skillshiftapp.ui.theme.DarkBlue2
import com.jejetrue.skillshiftapp.ui.theme.SoftBlue

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InfoProjectScreen() {
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())

    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = "Info Proyek",
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    ) },
                navigationIcon = {
                    IconButton(onClick = { /* do something */ }) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = "Localized description"
                        )
                    }
                },

                scrollBehavior = scrollBehavior,

            )

        }
    ) {innerPadiing ->
        Box {
            Column (
                modifier = Modifier.padding(innerPadiing)
            ){

                Box(modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
                    .background(
                        color = SoftBlue,
                        shape = RoundedCornerShape(8.dp)
                    )
                ) {

                    Column(modifier = Modifier.padding(15.dp)) {

                        //Info Project di Daftar Penawaran Anda -> jika diklik salah satu item, maka akan langsung ke halaman ini
                        //disini akan menampilkan info dan juga dibawah ada tombol pembatalan

                        JudulProyek()
                        Spacer(modifier = Modifier.height(10.dp))
                        SubJudulProyek()
                        Spacer(modifier = Modifier.height(15.dp))
                        Deskripsi()
                        Spacer(modifier = Modifier.height(8.dp))
                        ImageProject()
                        Spacer(modifier = Modifier.height(10.dp))
                        Keterangan()
                        Spacer(modifier = Modifier.height(8.dp))
                        ButtonCancel()


                        



                    }
                }
            }
        }
    }
}

@Composable
fun JudulProyek() {
    Text(text = "Mobile Legends")
}

@Composable
fun SubJudulProyek() {
    Text(text = "Teks ini untuk subjudul pada proyek ini")
}

@Composable
fun Deskripsi() {
    Column {
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
    }
}

@Composable
fun ImageProject() {
    Image(
        painter = painterResource(id = R.drawable.testing),
        contentDescription = "",
        contentScale = ContentScale.Fit,
        modifier = Modifier.fillMaxWidth()
        )
}

@Composable
fun Keterangan() {
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
}

@Composable
fun ButtonCancel() {
    Button(onClick = {  }) {
        Icon(imageVector = Icons.Default.Cancel, contentDescription = "")
        Spacer(Modifier.size(ButtonDefaults.IconSpacing))
        Text(text = "batalkan")
        
    }
    
}

@Preview
@Composable
fun InfoProjectPreview() {
    InfoProjectScreen()
    
}