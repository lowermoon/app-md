@file:OptIn(ExperimentalMaterial3Api::class)

package com.jejetrue.skillshiftapp.view.main.profile

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DoNotDisturbOn
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Logout
import androidx.compose.material.icons.filled.ManageAccounts
import androidx.compose.material.icons.outlined.StackedBarChart
import androidx.compose.material.icons.rounded.TagFaces
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jejetrue.skillshiftapp.R
import com.jejetrue.skillshiftapp.ui.theme.SkillShiftAppTheme

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen(){
    Scaffold (
        topBar = {
            CenterAlignedTopAppBar(
                title = { 
                    Text(text = "Profile", maxLines = 1, overflow = TextOverflow.Ellipsis)
                },
                actions = {
                    IconButton(
                        onClick = {

                        }
                    ) {
                        Icon(imageVector = Icons.Default.ManageAccounts, contentDescription ="" )

                    }
                }
            )
            
        }
    ){contentPadding ->
        Column(
            modifier = Modifier
                .padding(contentPadding)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,

            ) {
            Spacer(modifier = Modifier.height(20.dp))
            ImageProfile()
            Spacer(modifier = Modifier.height(15.dp))


            UserName()
            Email()
            Role()

            Spacer(modifier = Modifier.height(20.dp))
            Box(modifier = Modifier.background(Color.LightGray))
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp)
                    .height(200.dp)
                    .background(
                        Color.LightGray,
                        shape = RoundedCornerShape(16.dp)
                    ),
            ){
                Column(modifier = Modifier.padding(8.dp)) {
                    DataStatik()
                    FaceID()
                    NonaktifAkun()
                    KeluarAkun()

                }
            }
        }

    }

}

@Composable
fun UserName() {
    Text(text = "@jihaanjj",)
}

@Composable
fun Email() {
    Text(text = "Jihaan Jasmine Jahroo")
}

@Composable
fun ImageProfile() {
    Image(
        painter = painterResource(R.drawable.dummyphoto),
        contentDescription = "photo profile",
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .size(150.dp)
            .border(
                BorderStroke(4.dp, Color.Red),
                CircleShape
            )
            .padding(4.dp)
            .clip(CircleShape)
        )
}

@Composable
fun Role() {
    Box(
        modifier = Modifier
            .background(Color.LightGray)
    ){
        Text(
            text = "freelance",
        )
    }
}

@Composable
fun FaceID() {
    TextButton(onClick = { /*TODO*/ }) {
        Icon(imageVector = Icons.Rounded.TagFaces, contentDescription ="" )
        Spacer(Modifier.size(ButtonDefaults.IconSpacing))
        Text(text = "Verifikasi identifikasi wajah")
        Spacer(modifier = Modifier.width(10.dp))
    }
}

@Composable
fun NonaktifAkun() {
    TextButton( onClick = { /*TODO*/ }) {
        Icon(imageVector = Icons.Default.DoNotDisturbOn, contentDescription ="" )
        Spacer(Modifier.size(ButtonDefaults.IconSpacing))
        Text(text = "Nonaktifkan Akun")
        Spacer(modifier = Modifier.width(10.dp))
    }
}

@Composable
fun KeluarAkun() {
    TextButton( onClick = { /*TODO*/ }) {
        Icon(imageVector = Icons.Default.Logout, contentDescription ="" )
        Spacer(Modifier.size(ButtonDefaults.IconSpacing))
        Text(text = "Keluar dari akun ini")
        Spacer(modifier = Modifier.width(10.dp))
    }
}

@Composable
fun DataStatik() {
    TextButton( onClick = { /*TODO*/ }) {
        Icon(imageVector = Icons.Outlined.StackedBarChart, contentDescription ="" )
        Spacer(Modifier.size(ButtonDefaults.IconSpacing))
        Text(text = "Data statistik anda")
        Spacer(modifier = Modifier.width(10.dp))
    }
    
}
    






@Preview(showBackground = true)
@Composable
fun ProfilePreview() {
    SkillShiftAppTheme {
        ProfileScreen ()
    }

}