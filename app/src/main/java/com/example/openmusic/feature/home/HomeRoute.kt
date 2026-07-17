package com.example.openmusic.feature.home

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.openmusic.domain.model.Song
import com.example.openmusic.domain.viewmodel.HomeViewModel
import com.example.openmusic.presentation.screens.HomeScreen

@Composable
fun HomeRoute(

    onSongClick: (Song) -> Unit,

    viewModel: HomeViewModel =
        hiltViewModel()

) {

    val state by viewModel
        .state
        .collectAsStateWithLifecycle()

    HomeScreen(

        state = state,

        onSongClick = onSongClick

    )

}