package com.example.openmusic.presentation.splash


sealed interface SplashDestination {

    data object None : SplashDestination

    data object Login : SplashDestination

    data object Home : SplashDestination

}