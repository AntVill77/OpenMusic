package com.example.openmusic.feature.player.data

import com.example.openmusic.feature.player.domain.PlayerController
import com.example.openmusic.feature.player.presentation.PlayerUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PlayerControllerImpl @Inject constructor(

) : PlayerController {

    private val _playerState =
        MutableStateFlow(PlayerUiState())

    override val playerState: StateFlow<PlayerUiState> =
        _playerState.asStateFlow()

    override suspend fun play(songId: String) {

    }

    override fun pause() {

    }

    override fun resume() {

    }

    override fun stop() {

    }

    override fun seekTo(position: Long) {

    }

}