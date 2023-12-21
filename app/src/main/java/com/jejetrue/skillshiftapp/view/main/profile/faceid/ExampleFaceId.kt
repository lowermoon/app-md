package com.jejetrue.skillshiftapp.view.main.profile.faceid

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.core.content.FileProvider
import coil.compose.rememberAsyncImagePainter
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.rememberPermissionState
import com.jejetrue.skillshiftapp.ComposeFileProvider
import java.util.Objects

@Composable
fun ExampleScreenFaceId() {
    val context = LocalContext.current
    var hasImage by remember { mutableStateOf(false) }
    val file = ComposeFileProvider.createImageFile(context)
    val uri = FileProvider.getUriForFile(
        Objects.requireNonNull(context),
        context.packageName + ".fileprovider",
        file
    )
    var capturedImageUri by remember { mutableStateOf<Uri>(Uri.EMPTY) }
    val cameraLauncher = rememberLauncherForActivityResult(ActivityResultContracts.TakePicture()) {
        capturedImageUri = uri
        hasImage = true
    }

    CameraPermission {
        cameraLauncher.launch(uri)
    }
    
    if ( hasImage ) {
        DisplayImageFromUri(imageUri = capturedImageUri)
    }
}

@Composable
fun DisplayImageFromUri(imageUri: Uri) {
    val painter = rememberAsyncImagePainter(model = imageUri)
    Image(
        painter = painter,
        contentDescription = null,
        modifier = Modifier
            .size(180.dp)
            .clip(RoundedCornerShape(14.dp)),
        contentScale = ContentScale.Crop
    )
}

@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun CameraPermission(
    onPermessionSuccess: () -> Unit
) {
    val cameraPermissionState = rememberPermissionState(android.Manifest.permission.CAMERA)

    if (!cameraPermissionState.hasPermission) {
        Dialog(onDismissRequest = {}) {
            Text(text = "Butuh ijin kamera untuk menggunakan fitur ini !")
            Button(onClick = {
                cameraPermissionState.launchPermissionRequest()
            }) {
                Text(text = "Ijinkan !")
            }
        }
    }else {
        Button(onClick = { onPermessionSuccess() }) {
            Text(text = "Open Camera")
        }
    }
}