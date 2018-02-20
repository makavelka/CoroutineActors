package com.example.vladimir.coroutineactors.presentation

import android.os.Handler
import android.os.Looper
import kotlinx.coroutines.experimental.CoroutineDispatcher
import kotlinx.coroutines.experimental.Runnable
import kotlin.coroutines.experimental.CoroutineContext

/**
 * @author Tebloev Vladimir
 */
object UiDispatcher : CoroutineDispatcher() {
    private val mHandler: Handler = Handler(Looper.getMainLooper())

    override fun dispatch(context: CoroutineContext, block: Runnable) {
        mHandler.post(block)
    }
}
