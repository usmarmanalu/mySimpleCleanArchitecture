package com.dicoding.mysimplecleanarchitecture.presentation

import androidx.lifecycle.*
import com.dicoding.mysimplecleanarchitecture.domain.*

class MainViewModel(private val messageUseCase: MessageUseCase) : ViewModel() {

    private val _message = MutableLiveData<MessageEntity>()
    val message: LiveData<MessageEntity> get() = _message

    fun setName(name: String) {
        _message.value = messageUseCase.getMessage(name)
    }
}