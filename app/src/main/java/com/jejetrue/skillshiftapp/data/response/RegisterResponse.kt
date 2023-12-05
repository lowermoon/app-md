package com.jejetrue.skillshiftapp.data.response

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController
import com.google.gson.Gson
import com.google.gson.annotations.SerializedName
import com.jejetrue.skillshiftapp.data.payload.dataRegister
import com.jejetrue.skillshiftapp.data.payload.dataVerif
import com.jejetrue.skillshiftapp.data.retrofit.ApiConfig
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody.Companion.toRequestBody


data class RegisterResponseData(

	@field:SerializedName("code")
	val code: Int? = null,

	@field:SerializedName("role")
	val role: String? = null,

	@field:SerializedName("status")
	val status: String? = null,

	@field:SerializedName("username")
	val username: String? = null,

	@field:SerializedName("token")
	val token: String? = null
)


data class RegisterResponse(
	@field:SerializedName("status")
	var status: String,

	@field:SerializedName("message")
	var message: String,

	@field:SerializedName("data")
	var data: RegisterResponseData
)

fun register(data: dataRegister): String {
	val service = ApiConfig.getApiService()
	val payload = Gson().toJson(data)
	val requestBody = payload.toRequestBody("application/json".toMediaTypeOrNull())
	val response = service.register(requestBody).execute()
	val token = response.body()?.data?.token
	return token.toString()
}

fun VerifAccount(data: dataVerif, token: String): String {
	val service = ApiConfig.getApiService()
	val payload = Gson().toJson(data)
	val requestBody = payload.toRequestBody("application/json".toMediaTypeOrNull())
	val response = service.verifyUser("saveData=" + token, requestBody).execute()
	return response.body()?.status.toString()
}