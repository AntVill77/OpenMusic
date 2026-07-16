package com.example.openmusic.presentation.home

import com.example.openmusic.domain.model.Song

data class HomeState(

    val songs: List<Song> = emptyList(),

    val loading: Boolean = false
)