package com.example.openmusic.data.mapper

import com.example.openmusic.data.local.entity.SongEntity
import com.example.openmusic.domain.model.Song

fun SongEntity.toDomain(): Song =
    Song(
        id = id,
        title = title,
        composer = composer,
        category = category,
        description = description,
        duration = duration,
        imageUrl = imageUrl,
        audioUrl = audioUrl,
        videoUrl = videoUrl,
        lyrics = lyrics,
        isFavorite = false
    )

fun Song.toEntity(): SongEntity =
    SongEntity(
        id = id,
        title = title,
        composer = composer,
        category = category,
        description = description,
        duration = duration,
        imageUrl = imageUrl,
        audioUrl = audioUrl,
        videoUrl = videoUrl,
        lyrics = lyrics,
        updatedAt = System.currentTimeMillis()
    )