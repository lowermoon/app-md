package com.jejetrue.skillshiftapp.view.main.profile.editprofile

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jejetrue.skillshiftapp.R
import com.jejetrue.skillshiftapp.ui.theme.DarkBlueBG
import com.jejetrue.skillshiftapp.ui.theme.SkillShiftAppTheme
import com.jejetrue.skillshiftapp.ui.theme.TextFieldColor
import com.jejetrue.skillshiftapp.ui.theme.Yellow1


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditProfile(
    onBackClick:() -> Unit
) {
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())

    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),

        topBar = {
            CenterAlignedTopAppBar(

                title = {
                    Text(text = "Edit Profile", maxLines = 1, overflow = TextOverflow.Ellipsis, color = Color.White)
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(containerColor = DarkBlueBG),


                //kembali ke halaman sebelum nya
                navigationIcon = {
                    IconButton(
                        onClick = {
                            onBackClick()

                        }
                    ) {
                        Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "", tint = Color.White)
                    }
                },
            )
        }
    ) {contentPadding ->
        Box(modifier = Modifier
            .background(DarkBlueBG)
            .fillMaxSize()
        ){
            Column(
                modifier = Modifier
                    .padding(contentPadding)
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,

                ) {
                Spacer(modifier = Modifier.height(20.dp))
                //foto
                ProfileImage()

                Spacer(modifier = Modifier.height(15.dp))


                Spacer(modifier = Modifier.height(20.dp))

                Column(modifier = Modifier.padding(20.dp)) {
                    //form
                    InputData()

                    Spacer(modifier = Modifier.height(20.dp))

                }

                //tombol
                ElevatedButton(
                    onClick = {  }
                )
                {
                    Icon(imageVector = Icons.Default.CheckCircle, contentDescription = "", tint = Color.Green )
                    Text(text = "Submit", color = Color.Green )

                }

            }

        }

    }
}


@Composable
fun ProfileImage(

) {
    Image(
        painter = painterResource(R.drawable.dummyphoto),
        contentDescription = "photo profile",
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .size(100.dp)
            .clip(CircleShape)
            .clickable {  }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InputData() {
    var fullName by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var username by remember { mutableStateOf("") }
    var nik by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }



    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),

        value = fullName,
        onValueChange = {fullName = it},
        label = {
            Text(text = "Nama Lengkap", color = Color.White)
        },
        shape = RoundedCornerShape(20.dp),
        colors = TextFieldDefaults.colors(
            focusedContainerColor = TextFieldColor,
            unfocusedContainerColor = TextFieldColor,
            disabledContainerColor = TextFieldColor,
            focusedLabelColor = Yellow1

        )
    )

    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),

        value = email,
        onValueChange = {email = it},
        label = {
            Text(text = "Email", color = Color.White)
        },
        shape = RoundedCornerShape(20.dp),
        colors = TextFieldDefaults.colors(
            focusedContainerColor = TextFieldColor,
            unfocusedContainerColor = TextFieldColor,
            disabledContainerColor = TextFieldColor,
            focusedLabelColor = Yellow1

            )
    )

    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),

        value = username,
        onValueChange = {username = it},
        label = {
            Text(text = "Nama pengguna", color = Color.White)
        },
        shape = RoundedCornerShape(20.dp),
        colors = TextFieldDefaults.colors(
            focusedContainerColor = TextFieldColor,
            unfocusedContainerColor = TextFieldColor,
            disabledContainerColor = TextFieldColor,
            focusedLabelColor = Yellow1

            )
    )

    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),

        value = nik,
        onValueChange = {nik = it},
        label = {
            Text(text = "NIK", color = Color.White)
        },
        shape = RoundedCornerShape(20.dp),
        colors = TextFieldDefaults.colors(
            focusedContainerColor = TextFieldColor,
            unfocusedContainerColor = TextFieldColor,
            disabledContainerColor = TextFieldColor,
            focusedLabelColor = Yellow1

            )
    )

    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),

        value = password,
        onValueChange = {password = it},
        label = {
            Text(text = "Kata sandi", color = Color.White)
        },
        shape = RoundedCornerShape(20.dp),
        colors = TextFieldDefaults.colors(
            focusedContainerColor = TextFieldColor,
            unfocusedContainerColor = TextFieldColor,
            disabledContainerColor = TextFieldColor,
            focusedLabelColor = Yellow1

            )
    )
    
}




@Preview
@Composable
fun EditProfilePreview() {
    SkillShiftAppTheme {
        EditProfile(
            onBackClick = {}
        )
    }

}