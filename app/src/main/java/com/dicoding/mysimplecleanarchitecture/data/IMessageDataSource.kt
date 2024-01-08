package com.dicoding.mysimplecleanarchitecture.data

import com.dicoding.mysimplecleanarchitecture.domain.*

interface IMessageDataSource {

    fun getMessageFromSource(name: String): MessageEntity
}