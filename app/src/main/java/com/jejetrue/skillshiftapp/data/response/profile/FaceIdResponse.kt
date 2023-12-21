package com.jejetrue.skillshiftapp.data.response.profile

import android.content.Context
import android.graphics.Bitmap
import android.net.Uri
import com.google.gson.annotations.SerializedName
import com.jejetrue.skillshiftapp.data.response.convertImageToBitmap
import com.jejetrue.skillshiftapp.data.retrofit.ApiConfig
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody.Companion.toRequestBody
import java.io.ByteArrayOutputStream

data class FaceIdResponse(
	@field:SerializedName("message")
	val message: List<MessageFaceId?>? = null
)

data class MessageFaceId(
	@field:SerializedName("publicUrl")
	val publicUrl: String? = null,

	@field:SerializedName("message")
	val message: String? = null,

	@field:SerializedName("status")
	val status: String? = null
)

fun newFaceIdReq(
	firstImage: Uri,
	secondImage: Uri,
	thirdImage: Uri,
	context: Context,
	token: String
): FaceIdResponse? {
	val service = ApiConfig.getApiService()

	val first = convertImageToBitmap(firstImage, context)
	val second = convertImageToBitmap(secondImage, context)
	val third = convertImageToBitmap(thirdImage, context)

	val response = service.newfaceId(
		token = "verifyToken=$token",
		firstImage = getRequestQueryFace(first),
		secondImage = getRequestQueryFace(second),
		thirdImage = getRequestQueryFace(third)
	).execute()
	return response.body()
}

fun getRequestQueryFace(image: Bitmap): MultipartBody.Part {
	// conver
	val stream = ByteArrayOutputStream()
	image.compress(Bitmap.CompressFormat.JPEG, 80, stream)
	val byteArray = stream.toByteArray()
	return MultipartBody.Part.createFormData(
		"file", "BaharProfile", byteArray.toRequestBody("image/jpeg".toMediaTypeOrNull(), 0, byteArray.size)
	)
}