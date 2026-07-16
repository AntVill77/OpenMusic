package com.example.openmusic.domain.model

data class SongDto(

    val id: String = "",

    val title: String = "",

    val composer: String = "",

    val category: String = "",

    val description: String = "",

    val duration: String = "",

    val imageUrl: String = "",

    val audioUrl: String = "",

    val videoUrl: String = "",

    val lyrics: String = ""
)