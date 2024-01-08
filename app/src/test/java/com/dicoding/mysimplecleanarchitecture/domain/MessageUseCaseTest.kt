package com.dicoding.mysimplecleanarchitecture.domain

import com.dicoding.mysimplecleanarchitecture.data.*
import org.junit.*
import org.junit.runner.*
import org.mockito.*
import org.mockito.Mockito.verify
import org.mockito.Mockito.verifyNoMoreInteractions
import org.mockito.Mockito.`when`
import org.mockito.junit.*

@RunWith(MockitoJUnitRunner::class)
class MessageUseCaseTest {

    private lateinit var messageUseCase: MessageUseCase

    @Mock
    private lateinit var messageRepository: IMessageRepository

    @Before
    fun setUp() {
        messageUseCase = MessageInteractor(messageRepository)
        val dummyMessage = MessageEntity("Hello $NAME Welcome to Clean Architecture")
        `when` (messageRepository.getWelcomeMessage(NAME)).thenReturn(dummyMessage)
    }

    @Test
    fun `should get data from repository`() {
        val message = messageUseCase.getMessage(NAME)

        verify(messageRepository).getWelcomeMessage(NAME)
        verifyNoMoreInteractions(messageRepository)
        Assert.assertEquals("Hello $NAME Welcome to Clean Architecture", message.welcomeMessage)

    }

    companion object {
        const val NAME = "Usmar Manalu"
    }
}