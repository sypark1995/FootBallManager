package com.football.manager.view

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

@HiltAndroidApp
class FootBallApplication: Application() {
    override fun onCreate() {
        super.onCreate()
    }
}