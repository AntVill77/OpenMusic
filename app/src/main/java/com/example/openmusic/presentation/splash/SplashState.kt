package com.example.openmusic.presentation.splash


data class SplashState(

    val loading: Boolean = true,

    val destination: SplashDestination =
        SplashDestination.None

)