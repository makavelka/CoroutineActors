package com.example.vladimir.coroutineactors

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.channels.actor
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.launch
import kotlin.coroutines.experimental.CoroutineContext

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val counter = counterActor(this)
        launch(CommonPool) { //(5)
                delay(100)
                println("sending IncCounter message")
                counter.send("tttt")
                counter.send(133)
        }
    }

    fun counterActor(context: Context) = actor<Any>(CommonPool) { //(1)
        var counter = 0 //(9) actor state, not shared
        for (msg in channel) { // handle incoming messages
            when (msg) {
                is String -> {
                    Log.d("Coroutine", "string") //(4)
                    try {
                        Toast.makeText(context, "test", Toast.LENGTH_LONG).show()

                    } catch (e: Exception) {
                        println(e.toString())
                    }
                }
                is Int ->  Log.d("Coroutine", "int")//(3)
            }
        }
    }
}
