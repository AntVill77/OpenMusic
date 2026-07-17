package com.example.openmusic.presentation.screens

import androidx.compose.runtime.Composable
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.openmusic.domain.usecase.GetSongUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val getSong: GetSongUseCase
) : ViewModel() {
    // Add ViewModel implementation here if needed
}

@Composable
fun DetailScreen() {
    // Detail screen implementation
}

