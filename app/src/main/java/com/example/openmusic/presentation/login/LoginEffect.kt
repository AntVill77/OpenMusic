package com.example.openmusic.presentation.login

sealed interface LoginEffect {

    data object NavigateHome : LoginEffect

    data class ShowError(
        val message: String
    ) : LoginEffect
}