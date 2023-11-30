package com.jejetrue.skillshiftapp.di

import com.jejetrue.skillshiftapp.data.repository.UserRepository

object Injection {
    fun provideRepository(): UserRepository {
        return UserRepository.getInstance()
    }
}