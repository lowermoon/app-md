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
	val stream = ByteArrayOutputStream()
	val byteArray = stream.toByteArray()

	val first = convertImageToBitmap(firstImage, context)
	first.compress(Bitmap.CompressFormat.JPEG, 80, stream)
	val reqFirstImage = MultipartBody.Part.createFormData(
		"file", "face_id1", byteArray.toRequestBody("image/jpeg".toMediaTypeOrNull(), 0, first!!.byteCount)
	)

	val second = convertImageToBitmap(secondImage, context)
	second.compress(Bitmap.CompressFormat.JPEG, 80, stream)
	val reqSecondImage = MultipartBody.Part.createFormData(
		"file", "face_id1", byteArray.toRequestBody("image/jpeg".toMediaTypeOrNull(), 0, second!!.byteCount)
	)

	val third = convertImageToBitmap(thirdImage, context)
	third.compress(Bitmap.CompressFormat.JPEG, 80, stream)
	val reqThirdImage = MultipartBody.Part.createFormData(
		"file", "face_id1", byteArray.toRequestBody("image/jpeg".toMediaTypeOrNull(), 0, third!!.byteCount)
	)

	val response = service.newfaceId(
		token = "verifyToken=$token",
		firstImage = reqFirstImage,
		secondImage = reqSecondImage,
		thirdImage = reqThirdImage
	).execute()
	return response.body()
}