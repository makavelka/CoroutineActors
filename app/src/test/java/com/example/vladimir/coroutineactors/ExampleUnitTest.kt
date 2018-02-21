package com.example.vladimir.coroutineactors

import com.example.vladimir.coroutineactors.presentation.Calculator
import kotlinx.coroutines.experimental.channels.sendBlocking
import org.junit.Test

import org.junit.Assert.*
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {

    @Test
    fun actorTest() {
        val mock = mock(Calculator::class.java)
        `when`(mock.multipleX10(10)).thenReturn(100)
        val multipleActor = ActorSystem.createActor(ActorSystem.TypeActors.MULTIPLE_ACTOR)
        multipleActor?.sendBlocking(10)
        Mockito.verify(mock, times(1))
    }

    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }
}
