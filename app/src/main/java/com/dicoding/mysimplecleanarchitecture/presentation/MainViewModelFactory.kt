package com.dicoding.mysimplecleanarchitecture.presentation

import androidx.lifecycle.*
import com.dicoding.mysimplecleanarchitecture.di.*
import com.dicoding.mysimplecleanarchitecture.domain.*

@Suppress("UNCHECKED_CAST")
class MainViewModelFactory(private var messageUseCase: MessageUseCase) :
    ViewModelProvider.NewInstanceFactory() {

    companion object {
        @Volatile
        private var instance: MainViewModelFactory? = null

        fun getInstance(): MainViewModelFactory = instance ?: synchronized(this) {
            instance ?: MainViewModelFactory(Injection.provideUseCase())
        }
    }

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(MainViewModel::class.java) ->
                MainViewModel(messageUseCase) as T

            else -> throw IllegalArgumentException("Unknown ViewModel class: " + modelClass.name)
        }
    }
}