package com.example.openmusic.presentation.login

data class LoginState(

    val email: String = "",
    val password: String = "",
    val loading: Boolean = false,
    val error: String? = null
)