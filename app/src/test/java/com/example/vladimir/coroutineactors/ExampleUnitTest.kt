package com.example.vladimir.coroutineactors

import android.util.Log
import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.channels.actor
import kotlinx.coroutines.experimental.channels.sendBlocking
import kotlinx.coroutines.experimental.launch
import kotlinx.coroutines.experimental.runBlocking
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {

    @Test
    fun actorTest() {
        val counter = counterActor()
        val v = counter.sendBlocking("some")
        println(v.toString())
    }

    fun counterActor() = actor<Any>(CommonPool) { //(1)
        var counter = 0 //(9) actor state, not shared
        for (msg in channel) { // handle incoming messages
            when (msg) {
                is String -> Log.d("Coroutine", "string") //(4)
                is Int -> {
                    Log.d("Coroutine", "int")//(3)
//                    coroutineContext.

                }
            }
        }
    }
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }
}
