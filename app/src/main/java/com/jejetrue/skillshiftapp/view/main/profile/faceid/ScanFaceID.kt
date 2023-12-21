package com.jejetrue.skillshiftapp.view.main.profile.faceid

import android.net.Uri
import android.util.Log
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
import androidx.compose.runtime.LaunchedEffect
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
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.Objects

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScanFace() {
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())
    val context = LocalContext.current
    var lastImage by remember { mutableStateOf(false) }
    var sendToBe by remember { mutableStateOf(false) }
    val token = getToken()

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
            if ( firstImage == Uri.EMPTY ) {
                Image(painter = painterResource(id = R.drawable.scan_face_big), contentDescription ="" ,)
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = "Akun Anda belum terverifikasi")
                Spacer(modifier = Modifier.height(8.dp))
            }
            Box {
                if ( thirdImage != Uri.EMPTY ) {
                    DisplayImageFromUri(thirdImage)
                }
                if ( secondImage != Uri.EMPTY ) {
                    DisplayImageFromUri(secondImage)
                }
                if ( firstImage != Uri.EMPTY ) {
                    var fetchData by remember { mutableStateOf(false) }
                    LaunchedEffect(firstImage) {
                        CoroutineScope(Dispatchers.Default).launch {
                            fetchData = true
                        }
                    }
                    if ( fetchData ) {
                        DisplayImageFromUri(firstUri)
                    }
                }
            }

            Column{
                if ( firstImage == Uri.EMPTY ) {
                    Button(onClick = {
                        firstCameraLauncher.launch(firstImage)
                    }) {
                        Text(text = "Mulai Verifikasi Wajah 1")
                    }
                }
                if ( secondImage == Uri.EMPTY ) {
                    Button(onClick = {
                        secondCameraLauncher.launch(secondUri)
                    }) {
                        Text(text = "Mulai Verifikasi Wajah 2")
                    }
                }
                if ( thirdImage == Uri.EMPTY ) {
                    Button(onClick = {
                        thirdCameraLauncher.launch(thirdImage)
                        lastImage = true
                    }) {
                        Text(text = "Mulai Verifikasi Wajah 3")
                    }
                }

                if ( lastImage ) {
                    Button(onClick = {
                        sendToBe = true
                    }) {
                        Text(text = "Selesai...")
                    }
                }
            }
        }
    }

    if ( sendToBe ) {
        ExecApi {
            val response = newFaceIdReq(
                firstImage = firstImage,
                secondImage = secondImage,
                thirdImage = thirdImage,
                token = token,
                context = context
            )
            Log.d("ZAW", response.toString())
        }
    }
}