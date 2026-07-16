package com.example.openmusic.domain.model

data class Song(
    val id: String,
    val title: String,
    val composer: String,
    val description: String,
    val category: String,
    val duration: String,
    val imageUrl: String,
    val audioUrl: String,
    val videoUrl: String,
    val lyrics: String,
    val isFavorite: Boolean = false
)