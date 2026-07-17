package com.example.openmusic

import android.app.Application
import com.example.openmusic.core.sync.scheduler.SyncScheduler
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class OpenMusicApp : Application() {
    override fun onCreate() {
        super.onCreate()

        SyncScheduler.schedule(this)
    }
}