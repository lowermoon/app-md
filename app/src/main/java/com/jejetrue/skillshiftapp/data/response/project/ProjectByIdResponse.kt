package com.jejetrue.skillshiftapp.data.response.project

import com.google.gson.annotations.SerializedName
import com.jejetrue.skillshiftapp.data.retrofit.ApiConfig

data class ProjectById(
	@field:SerializedName("result")
	val result: SingleProjectResult? = null,

	@field:SerializedName("message")
	val message: String? = null,

	@field:SerializedName("status")
	val status: String? = null
)

data class ProjectByIdResponse(
	@field:SerializedName("project_id")
	val projectId: String? = null,

	@field:SerializedName("user_id")
	val userId: String? = null,

	@field:SerializedName("project_name")
	val projectName: String? = null,

	@field:SerializedName("deadline")
	val deadline: String? = null,

	@field:SerializedName("project_desc")
	val projectDesc: String? = null
)

data class SingleProjectResult(
	@field:SerializedName("project")
	val project: ProjectByIdResponse? = null
)

fun getProjectById(token: String, id: String): ProjectById? {
	val service = ApiConfig.getApiService()
	val response = service.getProjectByIdApi("verifyToken=$token", id).execute()
	return response.body()
}
