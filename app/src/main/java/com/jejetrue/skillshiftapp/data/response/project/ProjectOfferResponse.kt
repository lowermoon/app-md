package com.jejetrue.skillshiftapp.data.response.project

import com.google.gson.annotations.SerializedName

data class ProjectOfferResponse(

	@field:SerializedName("result")
	val result: Result? = null,

	@field:SerializedName("message")
	val message: String? = null,

	@field:SerializedName("status")
	val status: String? = null
)

data class Result(

	@field:SerializedName("findOffer")
	val findOffer: List<Any?>? = null
)
