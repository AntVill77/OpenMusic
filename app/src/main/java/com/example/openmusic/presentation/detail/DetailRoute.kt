package com.example.openmusic.presentation.detail

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.openmusic.presentation.screens.DetailScreen
import com.example.openmusic.presentation.screens.DetailViewModel

@Composable
fun DetailRoute(
    viewModel: DetailViewModel = hiltViewModel()
) {
    DetailScreen()
}

