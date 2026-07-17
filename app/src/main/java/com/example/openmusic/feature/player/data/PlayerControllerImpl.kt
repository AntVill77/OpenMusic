package com.example.openmusic.feature.player.data

import androidx.media3.common.MediaItem
import androidx.media3.common.MediaMetadata
import androidx.media3.common.Player
import androidx.media3.session.MediaController
import com.example.openmusic.feature.player.domain.PlayerController
import com.example.openmusic.feature.player.model.PlayableSong
import com.example.openmusic.feature.player.presentation.PlayerUiState
import com.google.common.util.concurrent.MoreExecutors
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PlayerControllerImpl @Inject constructor(
    private val controllerFactory: MediaControllerFactory
) : PlayerController {

    private lateinit var mediaController: MediaController

    private val scope = CoroutineScope(
        SupervisorJob() + Dispatchers.Main.immediate
    )

    private var progressJob: Job? = null
    private val _playerState = MutableStateFlow(PlayerUiState())

    override val playerState = _playerState.asStateFlow()


    override suspend fun play(song: PlayableSong) {
        val mediaItem = MediaItem.Builder()
            .setUri(song.audioUrl)
            .setMediaMetadata(MediaMetadata.Builder()
                    .setTitle(song.title)
                    .setArtist(song.artist)
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
                    if (isPlaying)
                        startProgressUpdates()
                    else
                        stopProgressUpdates()
                }

                override fun onMediaItemTransition(
                    mediaItem: MediaItem?,
                    reason: Int
                ) {

                    val metadata =
                        mediaItem?.mediaMetadata

                    _playerState.update {
                        it.copy(
                            title =
                                metadata?.title?.toString().orEmpty(),
                            artist =
                                metadata?.artist?.toString().orEmpty()
                        )
                    }
                }

                override fun onPlaybackStateChanged(playbackState: Int) {
                    _playerState.update {
                        it.copy(
                            isBuffering = playbackState == Player.STATE_BUFFERING
                        )
                    }
                }
            }
        )
    }

    private fun startProgressUpdates() {

        progressJob?.cancel()

        progressJob = scope.launch {

            while (isActive) {

                if (::mediaController.isInitialized) {

                    _playerState.update {

                        it.copy(

                            currentPosition =
                                mediaController.currentPosition,

                            duration =
                                mediaController.duration
                                    .coerceAtLeast(0L),

                            bufferedPosition =
                                mediaController.bufferedPosition

                        )

                    }

                }

                delay(500)

            }

        }

    }

    private fun stopProgressUpdates() {

        progressJob?.cancel()

    }

}
