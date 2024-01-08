package com.dicoding.mysimplecleanarchitecture.di

import com.dicoding.mysimplecleanarchitecture.data.*
import com.dicoding.mysimplecleanarchitecture.domain.*

object Injection {
    fun provideUseCase(): MessageUseCase {
        val messageRepository = provideRepository()
        return MessageInteractor(messageRepository)
    }

    private fun provideRepository(): IMessageRepository {
        val messageDataSource = provideDataSource()
        return MessageRepository(messageDataSource)
    }

    private fun provideDataSource(): IMessageDataSource {
        return MessageDataSource()
    }
}