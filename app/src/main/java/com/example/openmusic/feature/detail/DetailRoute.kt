package com.example.openmusic.feature.detail

import androidx.compose.runtime.Composable
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import com.example.openmusic.presentation.screens.DetailScreen
import com.example.openmusic.presentation.screens.DetailViewModel

@Composable
fun DetailRoute(
    viewModel: DetailViewModel = hiltViewModel()
) {
    DetailScreen()
}

