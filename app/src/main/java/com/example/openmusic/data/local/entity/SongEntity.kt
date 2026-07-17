package com.example.openmusic.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "songs")
data class SongEntity(

    @PrimaryKey
    val id: String,

    val title: String,

    val composer: String,

    val category: String,

    val description: String,

    val duration: String,

    val imageUrl: String,

    val audioUrl: String,

    val videoUrl: String,

    val lyrics: String,

    val updatedAt: Long
)