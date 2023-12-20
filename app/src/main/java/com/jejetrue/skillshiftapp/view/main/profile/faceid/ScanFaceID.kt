package com.jejetrue.skillshiftapp.view.main.profile.faceid

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jejetrue.skillshiftapp.R
import com.jejetrue.skillshiftapp.ui.theme.SkillShiftAppTheme
import com.jejetrue.skillshiftapp.view.main.profile.Email
import com.jejetrue.skillshiftapp.view.main.profile.FaceID
import com.jejetrue.skillshiftapp.view.main.profile.ImageProfile
import com.jejetrue.skillshiftapp.view.main.profile.KeluarAkun
import com.jejetrue.skillshiftapp.view.main.profile.Role
import com.jejetrue.skillshiftapp.view.main.profile.SetProfileButton
import com.jejetrue.skillshiftapp.view.main.profile.UserName

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScanFace() {
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())
    Scaffold (
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            CenterAlignedTopAppBar(
                title = {
//                    Text(
//                        text = "Info Proyek",
//                        maxLines = 1,
//                        overflow = TextOverflow.Ellipsis
//                    )
                   },
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
    ){innerPadding ->
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .verticalScroll(rememberScrollState())
        ) {

            Image(painter = painterResource(id = R.drawable.scan_face_big), contentDescription ="" ,)
            Spacer(modifier = Modifier.height(8.dp))

            Text(text = "Akun Anda belum terverifikasi")
            Spacer(modifier = Modifier.height(8.dp))

            Button(onClick = { /*TODO*/ }) {
                Text(text = "Mulai Verifikasi")
                
            }

        }
    }
    
}

@Preview
@Composable
fun ScanPreview() {
    SkillShiftAppTheme {
        ScanFace()
    }

}