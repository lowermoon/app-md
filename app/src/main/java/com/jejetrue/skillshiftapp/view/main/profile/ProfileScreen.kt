@file:OptIn(ExperimentalMaterial3Api::class)

package com.jejetrue.skillshiftapp.view.main.profile

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.material.icons.filled.Logout
import androidx.compose.material.icons.filled.ManageAccounts
import androidx.compose.material.icons.outlined.StackedBarChart
import androidx.compose.material.icons.rounded.TagFaces
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jejetrue.skillshiftapp.R
import com.jejetrue.skillshiftapp.data.datastore.UserStore
import com.jejetrue.skillshiftapp.data.response.DataProfileResponse
import com.jejetrue.skillshiftapp.data.response.getProfile
import com.jejetrue.skillshiftapp.data.retrofit.ExecApi
import com.jejetrue.skillshiftapp.ui.theme.SkillShiftAppTheme

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen(
    onEditProfileClick: () -> Unit
){
    val context = LocalContext.current
    val store = UserStore(context)
    val token = store.getAccessToken.collectAsState(initial = "")
    var loading by remember { mutableStateOf(true) }
    var response by remember {
        mutableStateOf<DataProfileResponse?>(null)
    }
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())
    if ( token.value !== "" ) {
        if ( response == null ) {
            ExecApi {
                response = getProfile(token.value)
                loading = false
            }
        }
    }

    Scaffold (
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            CenterAlignedTopAppBar(
                title = {
//                    Text(text = "Profile", maxLines = 1, overflow = TextOverflow.Ellipsis, color = Color.White)
                },
                actions = {
                    SetProfileButton(onEditProfileClick)
                }
            )
            
        }
    ){contentPadding ->
        if ( !loading && response !== null ) {
            Column(
                modifier = Modifier
                    .padding(contentPadding)
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,

                ) {
                Column(modifier = Modifier.padding(vertical = 20.dp)) {
                    ImageProfile()
                }

                UserName("@${response?.name.toString()}")
                Email(response?.email.toString())
                Role(response?.role.toString())

                Column( modifier = Modifier.padding(horizontal = 50.dp) ) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(200.dp)
                            .padding(vertical = 20.dp)
                            .clip(RoundedCornerShape(16.dp))
                            .background(color = MaterialTheme.colorScheme.onSecondary),
                    ){
                        Column(modifier = Modifier.padding(vertical = 8.dp, horizontal = 15.dp)) {
                            DataStatik()
                            FaceID()
                            NonaktifAkun()
                            KeluarAkun()
                        }
                    }
                }
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun PreviewSetProfileButton(){
    SetProfileButton {

    }
}

@Composable
fun SetProfileButton(
    onEditProfileClick: () -> Unit
) {
    IconButton(
        onClick = {
            onEditProfileClick()
        },
        modifier = Modifier
            .padding(end = 20.dp)
            .clip(RoundedCornerShape(50))
            .background(color = MaterialTheme.colorScheme.onSecondary)
    ) {
        Column(
            modifier = Modifier
                .size(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Icon(
                imageVector = Icons.Default.ManageAccounts,
                contentDescription ="",
                tint = Color.White
            )
        }
    }
}

@Composable
fun UserName(username: String) {
    Text(
        text = username,
        fontSize = 10.sp
    )
}

@Composable
fun Email(email: String) {
    Text(text = email)
}

@Composable
fun ImageProfile() {
    Image(
        painter = painterResource(R.drawable.dummyphoto),
        contentDescription = "photo profile",
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .size(100.dp)
            .clip(CircleShape))
}

@Composable
fun Role(role: String) {
    Box(
        modifier = Modifier
            .background(
                color = MaterialTheme.colorScheme.onSecondary,
                shape = RoundedCornerShape(30.dp)
            ),
    ){
        Text(
            text = role,
            color = MaterialTheme.colorScheme.error,
            fontSize = 10.sp,
            modifier = Modifier.padding(horizontal = 10.dp),
        )
    }
}

@Composable
fun FaceID() {
    TextButton(onClick = { /*TODO*/ }) {
        Icon(imageVector = Icons.Rounded.TagFaces, contentDescription ="", tint = Color.White )
        Spacer(Modifier.size(ButtonDefaults.IconSpacing))
        Text(text = "Verifikasi identifikasi wajah", color = Color.White)
        Spacer(modifier = Modifier.width(10.dp))
    }
}

@Composable
fun NonaktifAkun() {
    TextButton( onClick = { /*TODO*/ }) {
        Icon(imageVector = Icons.Default.DoNotDisturbOn, contentDescription ="" , tint = Color.Red)
        Spacer(Modifier.size(ButtonDefaults.IconSpacing))
        Text(text = "Nonaktifkan Akun", color = Color.Red)
        Spacer(modifier = Modifier.width(10.dp))
    }
}

@Composable
fun KeluarAkun() {
    TextButton( onClick = { /*TODO*/ }) {
        Icon(imageVector = Icons.Default.Logout, contentDescription ="", tint = Color.Red )
        Spacer(Modifier.size(ButtonDefaults.IconSpacing))
        Text(text = "Keluar dari akun ini", color = Color.Red)
        Spacer(modifier = Modifier.width(10.dp))
    }
}

@Composable
fun DataStatik() {
    TextButton( onClick = { /*TODO*/ }) {
        Icon(imageVector = Icons.Outlined.StackedBarChart, contentDescription ="", tint = Color.White )
        Spacer(Modifier.size(ButtonDefaults.IconSpacing))
        Text(text = "Data statistik anda", color = Color.White)
        Spacer(modifier = Modifier.width(10.dp))
    }
    
}
    






@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ProfilePreview() {
    SkillShiftAppTheme {
        ProfileScreen (
            onEditProfileClick = {

            }
        )
    }

}