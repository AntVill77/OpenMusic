package com.example.openmusic.data.mapper

import com.example.openmusic.domain.model.Song
import com.example.openmusic.domain.model.SongDto

fun SongDto.toDomain() = Song(

    id = id,

    title = title,

    composer = composer,

    category = category,

    description = description,

    duration = duration,

    imageUrl = imageUrl,

    audioUrl = audioUrl,

    videoUrl = videoUrl,

    lyrics = lyrics
)