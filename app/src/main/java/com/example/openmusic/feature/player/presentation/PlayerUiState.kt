package com.example.openmusic.feature.player.presentation


data class PlayerUiState(

    val songId: String? = null,

    val title: String = "",

    val artist: String = "",

    val artwork: String = "",

    val playing: Boolean = false,

    val duration: Long = 0,

    val currentPosition: Long = 0,

    val bufferedPosition: Long = 0

)