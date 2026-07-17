package com.example.openmusic.feature.player.model

data class PlayableSong(
    val id: String,
    val title: String,
    val artist: String,
    val audioUrl: String,
    val artworkUrl: String
)