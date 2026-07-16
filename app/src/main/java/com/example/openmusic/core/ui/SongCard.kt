package com.example.openmusic.core.ui

import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.example.openmusic.domain.model.Song

@Composable
fun SongCard(
    song: Song
) {

    Card {

        Text(
            text = song.title
        )

        Text(
            text = song.composer
        )

        Text(
            text = song.duration
        )

    }

}