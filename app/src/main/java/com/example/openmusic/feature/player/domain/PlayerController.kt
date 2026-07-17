package com.example.openmusic.feature.player.domain


import com.example.openmusic.domain.model.Song
import com.example.openmusic.feature.player.presentation.PlayerUiState
import kotlinx.coroutines.flow.StateFlow

interface PlayerController {

    val playerState: StateFlow<PlayerUiState>

    suspend fun play(song: Song)

    fun pause()

    fun resume()

    fun stop()

    fun seekTo(position: Long)

}