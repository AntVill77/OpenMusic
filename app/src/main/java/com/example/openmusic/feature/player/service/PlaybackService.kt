package com.example.openmusic.feature.player.service

import androidx.media3.common.AudioAttributes
import androidx.media3.common.C
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.session.MediaSession
import androidx.media3.session.MediaSessionService
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PlaybackService : MediaSessionService() {

    private lateinit var player: ExoPlayer

    private var mediaSession: MediaSession? = null

    override fun onCreate() {

        super.onCreate()

        player = ExoPlayer.Builder(this)
            .build()

        player.setAudioAttributes(

            AudioAttributes.Builder()

                .setContentType(
                    C.AUDIO_CONTENT_TYPE_MUSIC
                )

                .setUsage(
                    C.USAGE_MEDIA
                )

                .build(),

            true

        )

        mediaSession =

            MediaSession.Builder(

                this,

                player

            ).build()

    }

    override fun onDestroy() {

        mediaSession?.release()

        player.release()

        super.onDestroy()

    }

    override fun onGetSession(

        controllerInfo: MediaSession.ControllerInfo

    ) = mediaSession

}