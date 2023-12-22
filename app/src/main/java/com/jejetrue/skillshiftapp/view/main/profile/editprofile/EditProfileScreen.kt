package com.jejetrue.skillshiftapp.view.main.profile.editprofile

import android.annotation.SuppressLint
import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
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
import androidx.compose.runtime.LaunchedEffect
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
import coil.compose.AsyncImage
import com.jejetrue.skillshiftapp.R
import com.jejetrue.skillshiftapp.data.payload.ProfileDetail
import com.jejetrue.skillshiftapp.data.repository.getToken
import com.jejetrue.skillshiftapp.data.response.DataProfileResponse
import com.jejetrue.skillshiftapp.data.response.convertImageToBitmap
import com.jejetrue.skillshiftapp.data.response.getProfile
import com.jejetrue.skillshiftapp.data.response.setProfileDetail
import com.jejetrue.skillshiftapp.data.response.setProfileImage
import com.jejetrue.skillshiftapp.data.retrofit.ExecApi
import com.jejetrue.skillshiftapp.ui.components.ErrorDialog
import com.jejetrue.skillshiftapp.ui.theme.SkillShiftAppTheme
import com.jejetrue.skillshiftapp.ui.theme.TextFieldColor
import com.jejetrue.skillshiftapp.ui.theme.Yellow1


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditProfile(
    onBackClick:() -> Unit
) {
    var fullName by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var telephoneNumber by remember { mutableStateOf("") }
    var nationalId by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var imageUri by remember { mutableStateOf<Uri?>(null) }

    var oldfullName by remember { mutableStateOf("") }
    var oldemail by remember { mutableStateOf("") }
    var oldtelephoneNumber by remember { mutableStateOf("") }
    var oldnationalId by remember { mutableStateOf("") }
    var oldimage by remember { mutableStateOf("") }

    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())
    var sendData by remember { mutableStateOf(false) }
    var passwordNone by remember { mutableStateOf(false) }
    val context = LocalContext.current
    var oldProfile by remember {
        mutableStateOf<DataProfileResponse?>(null)
    }
    val token = getToken()
    var loading by remember { mutableStateOf(true) }
    val galleryLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent(),
        onResult = { uri ->
            uri?.let {
                imageUri = it
            }
        }
    )

    if ( token !== "null" ){
        if ( token !== "" ) {
            ExecApi {
                oldProfile = getProfile(token)
                loading = false
            }
        }
    }
    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),

        topBar = {
            CenterAlignedTopAppBar(
                title = {},
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
        if ( !loading ) {
            Box(modifier = Modifier
                .fillMaxSize()
            ){
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .padding(contentPadding)
                        .fillMaxWidth().verticalScroll(rememberScrollState()),
                ) {

                    Spacer(modifier = Modifier.height(20.dp))

                    oldfullName = oldProfile?.name.toString()
                    oldemail = oldProfile?.email.toString()
                    oldtelephoneNumber = oldProfile?.telephoneNumber.toString()
                    oldnationalId = oldProfile?.nationalId.toString()
                    oldimage = oldProfile?.profile.toString()

                    //foto
                    ProfileImage(onClick = {
                        galleryLauncher.launch("image/*")
                    }, imageUri = oldimage, imageModel = imageUri)


                    //form
                    Column(modifier = Modifier.padding(20.dp)) {
                        InputData(
                            fullName = oldfullName,
                            fullNameInput = { fullName = it },
                            valfullName = fullName,

                            email = oldemail,
                            valemail = email,
                            emailInput = { email = it },

                            telephoneNumber = oldtelephoneNumber,
                            valtelephoneNumber = telephoneNumber,
                            telephoneNumberInput = { telephoneNumber = it },

                            nationalId = oldnationalId,
                            valnationalId = nationalId,
                            nationalIdInput = { nationalId = it },

                            password = password,
                            passwordInput = { password = it }
                        )
                        Spacer(modifier = Modifier.height(20.dp))
                    }

                    //tombol
                    TextButton(
                        onClick = {
                            sendData = true
                        },
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

        var showErrorDialog by remember { mutableStateOf(false) }
        var postSuccess by remember { mutableStateOf(false) }
        if (sendData) {
            if (password.isNotBlank()) {
                if (token.isNotBlank() && token != "null") {
                    ExecApi {
                        // saveImage
                        if (imageUri != null) {
                            setProfileImage(convertImageToBitmap(imageUri!!, context), token)
                        }

                        // update Detail
                        setProfileDetail(
                            ProfileDetail(
                                fullName = if (fullName.isBlank()) oldfullName else fullName,
                                email = if (email.isBlank()) oldemail else email,
                                telephoneNumber = if (telephoneNumber.isBlank()) oldtelephoneNumber else telephoneNumber,
                                nationalId = if (nationalId.isBlank()) oldnationalId else nationalId,
                                password = password
                            ),
                            token
                        )
                        postSuccess = true
                    }
                }
            } else {
                passwordNone = true
                showErrorDialog = true
            }
        }

        if (passwordNone) {
            if (showErrorDialog) {
                ErrorDialog(message = "Maaf, password tidak boleh kosong! Silakan masukkan password baru atau password lama Anda.",
                    onClose = { showErrorDialog = false }
                )
            }
            sendData = false
        }

        LaunchedEffect(postSuccess) {
            if ( postSuccess ) {
                onBackClick()
            }
        }
    }
}


@Composable
fun ProfileImage(
    onClick: () -> Unit = {},
    imageUri: String,
    imageModel: Uri? = null
) {
    Box(
        contentAlignment = Alignment.BottomEnd,
        modifier = Modifier.clickable {
            onClick()
        }
    ){
        Box(
            modifier = Modifier
                .width(100.dp)
                .height(100.dp)
        ){
            AsyncImage(
                model = imageUri,
                contentDescription = "photo profile",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxSize()
                    .size(100.dp)
                    .clip(CircleShape)
            )
            AsyncImage(
                model = imageModel,
                contentDescription = "Local Image",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxSize()
                    .size(100.dp)
                    .clip(CircleShape)
            )
        }
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

@Composable
fun InputData(
    fullName: String = "",
    valfullName: String = "",
    fullNameInput: (String) -> Unit,
    email: String = "",
    valemail: String = "",
    emailInput: (String) -> Unit,
    telephoneNumber: String = "",
    valtelephoneNumber: String = "",
    telephoneNumberInput: (String) -> Unit,
    nationalId: String = "",
    valnationalId: String = "",
    nationalIdInput: (String) -> Unit,
    password: String = "",
    passwordInput: (String) -> Unit,
) {

    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        value = valfullName,
        onValueChange = fullNameInput,
        placeholder = {
            Text(text = fullName, color = MaterialTheme.colorScheme.primary)
        },
        label = {
            Text(text = "Nama Lengkap", color = Color.White)
        },
        shape = RoundedCornerShape(20.dp),
        maxLines = 1,
        colors = TextFieldDefaults.colors(
            focusedContainerColor = TextFieldColor,
            unfocusedContainerColor = TextFieldColor,
            disabledContainerColor = TextFieldColor,
            focusedLabelColor = Yellow1

        )
    )

    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        value = valemail,
        onValueChange = emailInput,
        placeholder = {
            Text(text = email, color = MaterialTheme.colorScheme.primary)
        },
        label = {
            Text(text = "Email", color = Color.White)
        },
        shape = RoundedCornerShape(20.dp),
        maxLines = 1,
        colors = TextFieldDefaults.colors(
            focusedContainerColor = TextFieldColor,
            unfocusedContainerColor = TextFieldColor,
            disabledContainerColor = TextFieldColor,
            focusedLabelColor = Yellow1
        )
    )

    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        value = valtelephoneNumber,
        onValueChange = telephoneNumberInput,
        placeholder = {
            Text(text = telephoneNumber, color = MaterialTheme.colorScheme.primary)
        },
        label = {
            Text(text = "Telepon", color = Color.White)
        },
        shape = RoundedCornerShape(20.dp),
        maxLines = 1,
        colors = TextFieldDefaults.colors(
            focusedContainerColor = TextFieldColor,
            unfocusedContainerColor = TextFieldColor,
            disabledContainerColor = TextFieldColor,
            focusedLabelColor = Yellow1
        )
    )

    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        value = valnationalId,
        onValueChange = nationalIdInput,
        placeholder = {
            Text(text = nationalId, color = MaterialTheme.colorScheme.primary)
        },
        label = {
            Text(text = "National ID", color = Color.White)
        },
        shape = RoundedCornerShape(20.dp),
        maxLines = 1,
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
        onValueChange = passwordInput,
        label = {
            Text(text = "Kata sandi Baru", color = MaterialTheme.colorScheme.primary)
        },
        shape = RoundedCornerShape(20.dp),
        maxLines = 1,
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