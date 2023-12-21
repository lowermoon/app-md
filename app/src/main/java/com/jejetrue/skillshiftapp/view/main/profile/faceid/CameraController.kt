package com.jejetrue.skillshiftapp.view.main.profile.faceid

import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import coil.compose.rememberAsyncImagePainter
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.rememberPermissionState
import com.jejetrue.skillshiftapp.ui.components.DialogContainer

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
            DialogContainer(title = "Need Permission!", message = "Butuh ijin kamera untuk menggunakan fitur ini !") {
                Button(onClick = {
                    cameraPermissionState.launchPermissionRequest()
                }) {
                    Text(text = "CONFIRM")
                }
            }
        }
    }else {
        Button(onClick = { onPermessionSuccess() }) {
            Text(text = "Open Camera")
        }
    }
}