package com.jejetrue.skillshiftapp.view.home

import androidx.lifecycle.ViewModel
import com.jejetrue.skillshiftapp.data.repository.UserRepository
import com.jejetrue.skillshiftapp.model.User
import com.jejetrue.skillshiftapp.view.common.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class HomeViewModel(
    private val repository: UserRepository
): ViewModel(){
    private val _uiState: MutableStateFlow<UiState<User>> = MutableStateFlow(UiState.Loading)
    val uiState: StateFlow<UiState<User>> get() = _uiState

}