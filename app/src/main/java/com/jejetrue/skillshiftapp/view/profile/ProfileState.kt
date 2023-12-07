package com.jejetrue.skillshiftapp.view.profile


data class ProfileState(
    val uploadStatus: UploadStatus = UploadStatus.CANCELED,
    val progress: Int = 0,
    val speed: Double? = 0.0,
    val timeRemaining: Double? = 0.0,
    val fileName : String? = null,
    val fileSize : Double = 0.0
)

enum class UploadStatus {
    UPLOADING, PAUSED, COMPLETED, CANCELED
}