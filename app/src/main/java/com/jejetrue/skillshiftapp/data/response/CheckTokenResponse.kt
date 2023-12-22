package com.jejetrue.skillshiftapp.data.response

import com.google.gson.annotations.SerializedName
import com.jejetrue.skillshiftapp.data.retrofit.ApiConfig

data class CheckTokenResponse(
	@field:SerializedName("isValid")
	val isValid: Boolean? = null
)

fun checkTokenRes(token: String): CheckTokenResponse? {
	val service = ApiConfig.getApiService()
	val response = service.checkToken(token).execute()
	return response.body()
}
