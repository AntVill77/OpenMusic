package com.example.openmusic.presentation.home

sealed interface HomeEvent {

    data object LoadSongs : HomeEvent

}