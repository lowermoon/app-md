package com.jejetrue.skillshiftapp.data.response

import com.google.gson.Gson
import com.google.gson.annotations.SerializedName
import com.jejetrue.skillshiftapp.data.payload.dataVerif
import com.jejetrue.skillshiftapp.data.retrofit.ApiConfig
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody.Companion.toRequestBody

data class ProfileResponse(

	@field:SerializedName("telephoneNumber")
	val telephoneNumber: Any? = null,

	@field:SerializedName("role")
	val role: String? = null,

	@field:SerializedName("nationalId")
	val nationalId: Any? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("email")
	val email: String? = null,

	@field:SerializedName("username")
	val username: String? = null
)

fun getProfile(token: String): ProfileResponse? {
	val service = ApiConfig.getApiService()
	val response = service.getProfile("verifyToken=" + token).execute()
	return response.body()
}