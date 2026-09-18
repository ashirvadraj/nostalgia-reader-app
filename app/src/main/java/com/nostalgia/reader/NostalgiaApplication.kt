package com.nostalgia.reader

import android.app.Application

class NostalgiaApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        instance = this
    }

    companion object {
        lateinit var instance: NostalgiaApplication
            private set
    }
}
