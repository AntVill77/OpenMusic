package com.example.openmusic.presentation.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.openmusic.core.ui.SongCard

@Composable
fun HomeScreen(
    state: HomeState
) {

    LazyColumn(modifier = Modifier.padding(16.dp)
        .fillMaxSize(),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Top) {

        items(
            state.songs
        ) { song ->

            SongCard(song)

        }

    }

}