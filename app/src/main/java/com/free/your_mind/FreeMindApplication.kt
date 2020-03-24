package com.free.your_mind

import android.app.Application
import timber.log.Timber

class FreeMindApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        Timber.plant(Timber.DebugTree())
    }
}