package com.example.vladimir.coroutineactors

import android.content.Context
import android.widget.Toast
import com.example.vladimir.coroutineactors.presentation.UiDispatcher
import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.Job
import kotlinx.coroutines.experimental.channels.SendChannel
import kotlinx.coroutines.experimental.channels.actor
import kotlinx.coroutines.experimental.launch

/**
 * @author Tebloev Vladimir
 */
object ActorSystem {
    fun createActor(type: TypeActors): SendChannel<Any>? {
        when (type) {
            TypeActors.MULTIPLE_ACTOR -> {
                return multiplyActor()
            }
        }
        return null
    }


    private fun multiplyActor() = actor<Any>(CommonPool) {
        for (msg in channel) {
            when (msg) {
                is Int -> {
                    print("koroutine ")
                    println(msg*10)
                }
            }
        }
    }

    enum class TypeActors {
        UI_ACTOR,
        MULTIPLE_ACTOR
    }
}
