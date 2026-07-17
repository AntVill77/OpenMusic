package com.example.openmusic.core.sesion

sealed interface SessionState {

    data object Loading : SessionState

    data object Unauthenticated : SessionState

    data class Authenticated(

        val uid: String,

        val email: String?

    ) : SessionState

}