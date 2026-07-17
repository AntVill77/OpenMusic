package com.example.openmusic.data.local.entity

import com.example.openmusic.domain.model.Song

fun SongEntity.toDomain() = Song(

    id,

    title,

    composer,

    category,

    description,

    duration,

    imageUrl,

    audioUrl,

    videoUrl,

    lyrics
)