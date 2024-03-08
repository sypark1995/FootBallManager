package com.football.manager.view

import android.app.Application
import timber.log.Timber

class FootBallApplication: Application() {
    override fun onCreate() {
        super.onCreate()

        Timber.plant(Timber.DebugTree())
    }
}