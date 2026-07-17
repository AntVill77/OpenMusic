package com.example.openmusic.feature.player.domain


import com.example.openmusic.feature.player.model.PlayableSong
import com.example.openmusic.feature.player.presentation.PlayerUiState
import kotlinx.coroutines.flow.StateFlow

interface PlayerController {

    val playerState: StateFlow<PlayerUiState>

    suspend fun play(song: PlayableSong)

    fun pause()

    fun resume()

    fun stop()

    fun seekTo(position: Long)

}