package com.jejetrue.skillshiftapp.data.response.project

import com.google.gson.annotations.SerializedName
import com.jejetrue.skillshiftapp.data.retrofit.ApiConfig

data class ProjectResponse(
	@field:SerializedName("result")
	val result: Result? = null,

	@field:SerializedName("message")
	val message: String? = null,

	@field:SerializedName("status")
	val status: String? = null
)

data class Result(
	@field:SerializedName("project")
	val project: List<ProjectData?>? = null
)

data class ProjectData(
	@field:SerializedName("imgUrl")
	val imgUrl: String? = null,

	@field:SerializedName("project_id")
	val projectId: String? = null,

	@field:SerializedName("user_id")
	val userId: String? = null,

	@field:SerializedName("project_name")
	val projectName: String? = null,

	@field:SerializedName("deadline")
	val deadline: String? = null,

//	@field:SerializedName("project_category")
//	val projectCategory: List<String?>? = null,

	@field:SerializedName("project_desc")
	val projectDesc: String? = null
)


fun getAllProject(token: String): ProjectResponse? {
	val service = ApiConfig.getApiService()
	val response = service.getAllProject("verifyToken=$token").execute()
	return response.body()
}