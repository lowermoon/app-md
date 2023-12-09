package com.jejetrue.skillshiftapp.view

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import com.jejetrue.skillshiftapp.data.repository.UserRepository

class ViewModelFactory(private val repository: UserRepository) : ViewModelProvider.NewInstanceFactory() {
    @Suppress
    override fun <T : ViewModel> create(modelClass: Class<T>, extras: CreationExtras): T {
        return super.create(modelClass, extras)
    }
}