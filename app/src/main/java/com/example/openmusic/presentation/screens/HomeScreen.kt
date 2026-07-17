package com.example.openmusic.presentation.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.openmusic.core.ui.SongCard
import com.example.openmusic.domain.model.Song
import com.example.openmusic.feature.home.HomeState

@Composable
fun HomeScreen(
    state: HomeState,
    onSongClick: (Song) -> Unit
) {

    LazyColumn(modifier = Modifier.padding(16.dp)
        .statusBarsPadding()
        .fillMaxSize(),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Top) {

        items(state.songs) { song ->

            SongCard(song)
            Spacer(modifier = Modifier.height(16.dp))

        }

    }

}