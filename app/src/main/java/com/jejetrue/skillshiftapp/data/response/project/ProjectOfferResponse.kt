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

	@field:SerializedName("createdAt")
	val createdAt: String? = null,

	@field:SerializedName("freelancerId")
	val freelancerId: String? = null,

	@field:SerializedName("project_id")
	val projectId: String? = null,

	@field:SerializedName("user_id")
	val userId: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("freelancerName")
	val freelancerName: String? = null,

	@field:SerializedName("offer_price")
	val offerPrice: Int? = null,

	@field:SerializedName("offer_desc")
	val offerDesc: String? = null,

	@field:SerializedName("updatedAt")
	val updatedAt: String? = null
)

fun getAllOffer(token: String): ProjectOfferResponse? {
	val service = ApiConfig.getApiService()
	val response = service.getOfferProject("verifyToken=$token").execute()
	return response.body()
}