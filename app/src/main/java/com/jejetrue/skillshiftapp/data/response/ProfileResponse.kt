package com.jejetrue.skillshiftapp.data.response

import android.content.Context
import android.graphics.Bitmap
import android.graphics.ImageDecoder
import android.net.Uri
import android.os.Build
import android.provider.MediaStore
import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.google.gson.Gson
import com.google.gson.annotations.SerializedName
import com.jejetrue.skillshiftapp.data.datastore.UserStore
import com.jejetrue.skillshiftapp.data.payload.ProfileDetail
import com.jejetrue.skillshiftapp.data.retrofit.ApiConfig
import com.jejetrue.skillshiftapp.data.retrofit.ExecApi
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody.Companion.toRequestBody
import java.io.ByteArrayOutputStream

data class ProfileResponse(
	@field:SerializedName("data")
	val data: DataProfileResponse? = null,
	@field:SerializedName("message")
	val message: String? = null,
	@field:SerializedName("status")
	val status: String? = null
)

data class DataProfileResponse(
	@field:SerializedName("imageUrl")
	val imageUrl: String? = null,
	@field:SerializedName("name")
	val name: String? = null,
	@field:SerializedName("nationalId")
	val nationalId: String? = null,
	@field:SerializedName("username")
	val username: String? = null,
	@field:SerializedName("email")
	val email: String? = null,
	@field:SerializedName("telephoneNumber")
	val telephoneNumber: String? = null,
	@field:SerializedName("role")
	val role: String? = null,
)

data class SetProfileResponse(
	@field:SerializedName("status")
	val status: String? = null,
	@field:SerializedName("message")
	val message: String? = null,
)


fun getProfile(token: String): DataProfileResponse? {
	val service = ApiConfig.getApiService()
	val response = service.getProfile("saveData=$token").execute()
	Log.d("ZAW", response.body().toString())
	return response.body()
}

data class File(
	val file: String
)

fun setProfileImage(image: Bitmap, token: String): ProfileResponse? {
	val service = ApiConfig.getApiService()
	// conver
	val stream = ByteArrayOutputStream()
	image.compress(Bitmap.CompressFormat.JPEG, 80, stream)
	val byteArray = stream.toByteArray()
	val requestBody = MultipartBody.Part.createFormData(
		"file", "BaharProfile", byteArray.toRequestBody("image/jpeg".toMediaTypeOrNull(), 0, byteArray.size)
	)
	Log.d("ZAW", requestBody.toString())
	val response = service.chengeProfileImage("verifyToken=$token", requestBody).execute()
	return response.body()
}

fun setProfileDetail(dataProfile: ProfileDetail, token: String): SetProfileResponse? {
	val service = ApiConfig.getApiService()
	val payload = Gson().toJson(dataProfile)
	val requestBody = payload.toRequestBody("application/json".toMediaTypeOrNull())
	val response = service.setProfile("verifyToken=$token" ,requestBody).execute()
	return response.body()
}


fun convertImageToBitmap(uri: Uri, context: Context): Bitmap {
	// convert to beatmap
	return when {
		Build.VERSION.SDK_INT < 28 -> MediaStore.Images.Media.getBitmap(
			context.contentResolver, uri
		)

		else -> {
			val source = ImageDecoder.createSource(context.contentResolver, uri)
			ImageDecoder.decodeBitmap(source)
		}
	}
}


@Composable
fun ExampleSetProfile() {
	var imageUri by remember {
		mutableStateOf<Uri?>(null)
	}
	var sendImage by remember { mutableStateOf(false) }
	val galleryLauncher = rememberLauncherForActivityResult(
		contract = ActivityResultContracts.GetContent(),
		onResult = { uri ->
			uri?.let {
				imageUri = it
			}
		}
	)
	Box(
		modifier = Modifier
			.fillMaxHeight()
			.fillMaxWidth(),
		contentAlignment = Alignment.Center
	) {
//		AsyncImage(model = imageUri, contentDescription = "lorem")
		Column {
			Button(
				onClick = {
					galleryLauncher.launch("image/*")
				}
			) {
				Text(
					text = "Pick image"
				)
			}
			Button(onClick = {
				sendImage = true
			}) {
				Text(text = "Submit To Server")
			}
		}
	}

	val context = LocalContext.current
	val store = UserStore(context)
	val token = store.getAccessToken.collectAsState(
		initial = ""
	).value
	if (sendImage) {
		Log.d("ZAW", imageUri.toString())
		if ( sendImage ) {
			ExecApi {
				val test = setProfileImage(convertImageToBitmap(imageUri!!, context), token)
				Log.d("ZAW", "TEST : $test")
			}
		}
	}

}
