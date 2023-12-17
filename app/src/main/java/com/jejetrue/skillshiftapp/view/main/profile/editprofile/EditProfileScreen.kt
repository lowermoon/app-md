package com.jejetrue.skillshiftapp.view.main.profile.editprofile

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jejetrue.skillshiftapp.R
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
                    //Text(text = "Edit Profile", maxLines = 1, overflow = TextOverflow.Ellipsis, color = Color.White)
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(),


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
            .fillMaxSize()
        ){
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .padding(contentPadding)
                    .fillMaxWidth(),
            ) {
                Spacer(modifier = Modifier.height(20.dp))

                //foto
                ProfileImage()

                //form
                Column(modifier = Modifier.padding(20.dp)) {
                    InputData()
                    Spacer(modifier = Modifier.height(20.dp))
                }

                //tombol
                TextButton(
                    onClick = { /*TODO*/ },
                    modifier = Modifier
                        .width(160.dp)
                        .clip(RoundedCornerShape(50))
                        .background(color = MaterialTheme.colorScheme.inversePrimary)
                ) {
                    Icon(imageVector = Icons.Default.CheckCircle, contentDescription = "", tint = Color.Green )
                    Spacer(modifier = Modifier.width(23.dp))
                    Text(text = "Submit", color = Color.Green )
                }
            }

        }

    }
}


@Composable
fun ProfileImage(
    onClick: () -> Unit = {}
) {
    Box(
        contentAlignment = Alignment.BottomEnd,
    ){
        Image(
            painter = painterResource(R.drawable.dummyphoto),
            contentDescription = "photo profile",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(100.dp)
                .clip(CircleShape)
        )
        Box {
            Column(
                modifier = Modifier
                    .padding(5.dp)
                    .clip(RoundedCornerShape(50))
                    .background(color = MaterialTheme.colorScheme.background)
            ) {
                Column(
                    modifier = Modifier
                        .padding(4.dp)
                        .clip(RoundedCornerShape(50))
                        .background(MaterialTheme.colorScheme.inversePrimary)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_editphoto),
                        contentDescription = "",
                        modifier = Modifier
                            .padding(4.dp)
                            .size(14.dp)
                    )
                }
            }
        }
    }
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