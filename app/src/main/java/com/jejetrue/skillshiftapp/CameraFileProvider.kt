package com.jejetrue.skillshiftapp

import android.content.Context
import android.net.Uri
import android.os.Environment
import androidx.core.content.FileProvider
import java.io.File
import java.text.SimpleDateFormat
import java.util.Date


class ComposeFileProvider : FileProvider(
    R.xml.file_paths
) {
    companion object {
        fun getImageUri(context: Context): Uri {
            val directory = createImageFileTmp(context)
            val file = File.createTempFile(
                "selected_image_",
                ".png",
                directory,
            )
            val authority = context.packageName + ".fileprovider"
            return getUriForFile(
                context,
                authority,
                file,
            )
        }

        private fun createImageFileTmp(context: Context): File {
            // Buat nama file gambar
            val directory = context.getExternalFilesDir(Environment.DIRECTORY_PICTURES)
            return File.createTempFile(
                "face_id", // Awalan
                ".png", // Akhiran
                directory // Direktori
            )
        }

        fun createImageFile(context: Context): File {
            // Create an image file name
            val timeStamp = SimpleDateFormat("yyyyMMdd_HHmmss").format(Date())
            val imageFileName = "JPEG_" + timeStamp + "_"
            val directory = context.getExternalFilesDir(Environment.DIRECTORY_PICTURES)
            return File.createTempFile(
                imageFileName, /* prefix */
                ".jpg", /* suffix */
                directory
            )
        }
    }
}