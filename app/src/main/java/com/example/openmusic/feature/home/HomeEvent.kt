package com.example.openmusic.feature.home

sealed interface HomeEvent {

    data object LoadSongs : HomeEvent

}