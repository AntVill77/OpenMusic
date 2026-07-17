package com.example.openmusic.feature.player.presentation

import com.example.openmusic.feature.player.model.PlayableSong

sealed interface PlayerEvent {

    data class Play(
        val song: PlayableSong
    ) : PlayerEvent

    data object Pause : PlayerEvent

    data object Resume : PlayerEvent

    data object Stop : PlayerEvent

    data class SeekTo(
        val position: Long
    ) : PlayerEvent
}