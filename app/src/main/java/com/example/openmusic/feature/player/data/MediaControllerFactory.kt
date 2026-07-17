package com.example.openmusic.feature.player.data

import android.content.ComponentName
import android.content.Context
import androidx.media3.session.MediaController
import androidx.media3.session.SessionToken
import com.example.openmusic.feature.player.service.PlaybackService
import com.google.common.util.concurrent.ListenableFuture
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MediaControllerFactory @Inject constructor(

    @ApplicationContext
    private val context: Context

) {

    fun create(): ListenableFuture<MediaController> {

        val sessionToken = SessionToken(

            context,

            ComponentName(

                context,

                PlaybackService::class.java

            )

        )

        return MediaController.Builder(

            context,

            sessionToken

        ).buildAsync()

    }

}