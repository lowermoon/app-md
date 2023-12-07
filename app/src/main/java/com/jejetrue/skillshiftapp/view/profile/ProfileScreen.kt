package com.jejetrue.skillshiftapp.view.profile

import android.Manifest
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.core.content.ContextCompat
import androidx.navigation.NavHostController
import com.jejetrue.skillshiftapp.ui.components.PermissionDialog
import com.jejetrue.skillshiftapp.ui.components.ReadExternalStoragePermissionTextProvider

@RequiresApi(Build.VERSION_CODES.Q)
@Composable
fun ProfileScreen(navController: NavHostController, modifier: Modifier = Modifier) {
    var imageUri by remember {
        mutableStateOf<Uri?>(null)
    }
    val mediaPicker = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.PickVisualMedia(),
        onResult = { uri ->
            imageUri = uri
        })
    //This logic is only for image not for video
    LaunchedEffect(key1 = imageUri) {
        imageUri?.let { uri ->
            Log.d("ZAW", uri.toString())
        }
    }
//    Log.d("ZAW", )
}

@RequiresApi(Build.VERSION_CODES.Q)
@Composable
fun UploadProfileImage(
    navController: NavHostController
) {
    var isGrantedPerm by remember {
        mutableStateOf(false)
    }
    val checkPermission by remember { mutableStateOf(false) }


    val launcher = rememberLauncherForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { isGranted: Boolean ->
        isGrantedPerm = isGranted
    }
    val context = LocalContext.current
    
    if ( checkPermission ) {
        Button(
            onClick = {
                // Check permission
                when (PackageManager.PERMISSION_GRANTED) {
                    ContextCompat.checkSelfPermission(
                        context,
                        Manifest.permission.MEDIA_CONTENT_CONTROL
                    ) -> {
                        // Some works that require permission
                        Log.d("ExampleScreen","Code requires permission")
                    }
                    else -> {
                        // Asking for permission
                        launcher.launch(Manifest.permission.MEDIA_CONTENT_CONTROL)
                    }
                }
            }
        ) {
            Text(text = "Check and Request Permission")
        }

        if ( !isGrantedPerm ) {
            GetPermission(navController, context)
        }
    }
}

@RequiresApi(Build.VERSION_CODES.Q)
@Composable
fun GetPermission(navController: NavHostController, context: Context) {
    val intent = Intent.ACTION_APPLICATION_PREFERENCES

    // Permission Denied: Do something
    PermissionDialog(
        permissionTextProvider = ReadExternalStoragePermissionTextProvider(),
        isPermanentlyDeclined = false,
        onDismiss = {
            navController.navigate("home")
        },
        onOkClick = {
            context.startActivity(Intent(intent))
        }
    ) {
        Log.d("ZAW", "Gtau")
    }
}