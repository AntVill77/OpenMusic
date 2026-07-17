package com.example.openmusic.feature.player.data

import androidx.media3.common.MediaItem
import androidx.media3.common.MediaMetadata
import androidx.media3.common.Player
import androidx.media3.session.MediaController
import com.example.openmusic.domain.model.Song
import com.example.openmusic.feature.player.domain.PlayerController
import com.example.openmusic.feature.player.presentation.PlayerUiState
import com.google.common.util.concurrent.MoreExecutors
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PlayerControllerImpl @Inject constructor(
    private val controllerFactory: MediaControllerFactory
) : PlayerController {

    private lateinit var mediaController: MediaController
    private val _playerState = MutableStateFlow(PlayerUiState())

    override val playerState = _playerState.asStateFlow()

    override suspend fun play(song: Song) {
        val mediaItem = MediaItem.Builder()
            .setUri(song.audioUrl)
            .setMediaMetadata(MediaMetadata.Builder()
                    .setTitle(song.title)
                    .setArtist(song.composer)
                    .build())

        mediaController.setMediaItem(mediaItem.build())

        mediaController.prepare()

        mediaController.play()
    }

    override fun pause() {
        mediaController.pause()
    }

    override fun resume() {
        mediaController.play()
    }

    override fun stop() {
        mediaController.stop()
    }

    override fun seekTo(position: Long) {
        mediaController.seekTo(position)
    }

    init {
        initializeController()
    }

    private fun initializeController() {

        val future = controllerFactory.create()

        future.addListener({

            mediaController = future.get()

            observePlayer()

        },

            MoreExecutors.directExecutor()

        )

    }

    private fun observePlayer() {
        mediaController.addListener(
            object : Player.Listener {
                override fun onIsPlayingChanged(isPlaying: Boolean) {
                    _playerState.update {
                        it.copy(playing = isPlaying)
                    }
                }

                override fun onMediaItemTransition(mediaItem: MediaItem?, reason: Int) {
                    super.onMediaItemTransition(mediaItem, reason)
                }

                override fun onPlaybackStateChanged(playbackState: Int) {
                    super.onPlaybackStateChanged(playbackState)
                }
            }
        )
    }
}
