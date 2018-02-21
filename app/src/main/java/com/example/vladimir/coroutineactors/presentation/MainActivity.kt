package com.example.vladimir.coroutineactors.presentation

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.vladimir.coroutineactors.ActorSystem
import com.example.vladimir.coroutineactors.R
import kotlinx.coroutines.experimental.channels.SendChannel
import kotlinx.coroutines.experimental.channels.actor
import kotlinx.coroutines.experimental.launch

class MainActivity : AppCompatActivity(), MainView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setNumber(10)
    }

    override fun showResult(result: Int) {
        Toast.makeText(this, result.toString(), Toast.LENGTH_LONG).show()
    }

    override fun setNumber(num: Int) {
        launch {
            ActorSystem.createActor(ActorSystem.TypeActors.MULTIPLE_ACTOR)?.send(num)
        }
    }

    private fun uiActor(context: Context) = actor <Int>(UiDispatcher) {
        for (msg in channel) {
            showResult(msg)
        }
    }
}
