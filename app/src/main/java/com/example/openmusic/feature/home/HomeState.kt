package com.example.openmusic.feature.home

import com.example.openmusic.domain.model.Song

data class HomeState(

    val loading: Boolean = false,

    val songs: List<Song> = emptyList(),

    val search: String = "",

    val error: String? = null

)