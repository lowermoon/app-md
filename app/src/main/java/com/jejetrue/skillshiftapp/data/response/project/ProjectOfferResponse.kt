package com.jejetrue.skillshiftapp.data.response.project

import com.google.gson.annotations.SerializedName
import com.jejetrue.skillshiftapp.data.retrofit.ApiConfig

data class ProjectOfferResponse(
	@field:SerializedName("result")
	val result: ResultOffer? = null,

	@field:SerializedName("message")
	val message: String? = null,

	@field:SerializedName("status")
	val status: String? = null
)

data class ResultOffer(
	@field:SerializedName("findOffer")
	val findOffer: List<FindOfferItem> = emptyList()
)

data class FindOfferItem(
	@field:SerializedName("imgUrl")
	val imgUrl: String? = null,

	@field:SerializedName("project_name")
	val projectName: String? = null,

	@field:SerializedName("offer_price")
	val price: String? = null,

	@field:SerializedName("offer_desc")
	val desc: String? = null,

)

fun getAllOffer(token: String): ProjectOfferResponse? {
	val service = ApiConfig.getApiService()
	val response = service.getOfferProject("verifyToken=$token").execute()
	return response.body()
}