package com.jejetrue.skillshiftapp.view.main.profile.faceid

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.core.content.FileProvider
import com.jejetrue.skillshiftapp.ComposeFileProvider
import com.jejetrue.skillshiftapp.R
import com.jejetrue.skillshiftapp.data.repository.getToken
import com.jejetrue.skillshiftapp.data.response.profile.newFaceIdReq
import com.jejetrue.skillshiftapp.data.retrofit.ExecApi
import java.util.Objects

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScanFace(
    backToHome: () -> Unit
) {
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())
    val context = LocalContext.current
    var startVerify by remember { mutableStateOf(false) }
    var lastImage by remember { mutableStateOf(false) }
    var sendToBe by remember { mutableStateOf(false) }
    val token = getToken()
    CameraPermission {}

    // First Image
    var firstImage by remember { mutableStateOf<Uri>(Uri.EMPTY) }
    val firstFile = ComposeFileProvider.createImageFile(context)
    val firstUri = FileProvider.getUriForFile(
        Objects.requireNonNull(context),
        context.packageName + ".fileprovider",
        firstFile
    )
    val firstCameraLauncher = rememberLauncherForActivityResult(ActivityResultContracts.TakePicture()) {
        firstImage = firstUri
    }

    // Second Image
    var secondImage by remember { mutableStateOf<Uri>(Uri.EMPTY) }
    val secondtFile = ComposeFileProvider.createImageFile(context)
    val secondUri = FileProvider.getUriForFile(
        Objects.requireNonNull(context),
        context.packageName + ".fileprovider",
        secondtFile
    )
    val secondCameraLauncher = rememberLauncherForActivityResult(ActivityResultContracts.TakePicture()) {
        secondImage = secondUri
    }

    // Third Image
    var thirdImage by remember { mutableStateOf<Uri>(Uri.EMPTY) }
    val thirdtFile = ComposeFileProvider.createImageFile(context)
    val thirdUri = FileProvider.getUriForFile(
        Objects.requireNonNull(context),
        context.packageName + ".fileprovider",
        thirdtFile
    )
    val thirdCameraLauncher = rememberLauncherForActivityResult(ActivityResultContracts.TakePicture()) {
        thirdImage = thirdUri
    }

    Scaffold (
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            CenterAlignedTopAppBar(
                title = {},
                navigationIcon = {
                    IconButton(onClick = { backToHome() }) {
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
            if ( !startVerify ) {
                Image(painter = painterResource(id = R.drawable.scan_face_big), contentDescription ="" ,)
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = "Akun Anda belum terverifikasi")
                Spacer(modifier = Modifier.height(8.dp))
                Column {
                    Button(onClick = {
                        startVerify = true
                    }) {
                        Text(text = "Mulai Verifikasi Wajah")
                    }
                }
            }
            if ( startVerify ) {
                Box {
                    if ( thirdImage != Uri.EMPTY ) {
                        DisplayImageFromUri(thirdImage)
                    }
                    if ( secondImage != Uri.EMPTY ) {
                        DisplayImageFromUri(secondImage)
                    }
                    if ( firstImage != Uri.EMPTY ) {
                        DisplayImageFromUri(firstImage)
                    }
                }
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ){
                    Box {

                        if ( thirdImage == Uri.EMPTY ) {
                            Button(onClick = {
                                thirdCameraLauncher.launch(thirdUri)
                                lastImage = true
                            }) {
                                Text(text = "Mulai Verifikasi Wajah 3")
                            }
                        }
                        if ( secondImage == Uri.EMPTY ) {
                            Button(onClick = {
                                secondCameraLauncher.launch(secondUri)
                            }) {
                                Text(text = "Mulai Verifikasi Wajah 2")
                            }
                        }
                        if ( firstImage == Uri.EMPTY ) {
                            Button(onClick = {
                                firstCameraLauncher.launch(firstUri)
                            }) {
                                Text(text = "Mulai Verifikasi Wajah 1")
                            }
                        }
                        if ( lastImage ) {
                            if ( thirdImage != Uri.EMPTY ) {
                                Button(onClick = {
                                    sendToBe = true
                                }) {
                                    Text(text = "Selesai")
                                }
                            }
                        }

                    }
                }
            }
        }
    }

    var success by remember { mutableStateOf(false) }
    if ( sendToBe ) {
        ExecApi {
            val response = newFaceIdReq(
                firstImage = firstImage,
                secondImage = secondImage,
                thirdImage = thirdImage,
                token = token,
                context = context
            )
            if ( response?.message?.get(0)?.status == "success" ) {
                success = true
            }
        }
    }
    if ( success ) {
        backToHome()
    }
}