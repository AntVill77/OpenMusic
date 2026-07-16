package com.example.openmusic.data.mock

import com.example.openmusic.domain.model.Song

object FakeSongs {

    val songs = listOf(

        Song(
            id = "1",
            title = "Amazing Grace",
            composer = "John Newton",
            description = "Traditional hymn",
            category = "Hymn",
            duration = "03:15",
            imageUrl = "",
            audioUrl = "",
            videoUrl = "",
            lyrics = "Amazing grace..."
        ),

        Song(
            id = "2",
            title = "Greensleeves",
            composer = "Traditional",
            description = "English folk song",
            category = "Folk",
            duration = "02:55",
            imageUrl = "",
            audioUrl = "",
            videoUrl = "",
            lyrics = "Alas my love..."
        ),

        Song(
            id = "3",
            title = "Amazing Grace",
            composer = "John Newton",
            description = "Traditional hymn",
            category = "Hymn",
            duration = "03:15",
            imageUrl = "",
            audioUrl = "",
            videoUrl = "",
            lyrics = "Amazing grace..."
        ),

        Song(
            id = "4",
            title = "Greensleeves",
            composer = "Traditional",
            description = "English folk song",
            category = "Folk",
            duration = "02:55",
            imageUrl = "",
            audioUrl = "",
            videoUrl = "",
            lyrics = "Alas my love..."
        )
    )
}