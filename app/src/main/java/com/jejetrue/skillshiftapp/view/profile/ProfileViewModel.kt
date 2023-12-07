package com.jejetrue.skillshiftapp.view.profile

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class ProfileViewModel: ViewModel() {
    var profileState by mutableStateOf(ProfileState())
        private set
    val visiblePermissionDialogQueue = mutableListOf<String>()
    fun dismissDialog() {
        visiblePermissionDialogQueue.removeFirst()
    }
    fun onPermission(
        permission: String,
        isGranted: Boolean
    ) {
        if ( !isGranted && !visiblePermissionDialogQueue.contains(permission) ) {
            visiblePermissionDialogQueue.add(permission)
        }
    }
}