package com.football.manager.initializer

import android.content.Context
import androidx.startup.Initializer
import com.football.manager.BuildConfig
import timber.log.Timber

class TimberInitializer : Initializer<Unit> {

    override fun create(context: Context) {
        Timber.plant(Timber.DebugTree())
        Timber.d("TimberInitializer is initialized.")
    }

    override fun dependencies(): List<Class<out Initializer<*>>> = emptyList()
}
