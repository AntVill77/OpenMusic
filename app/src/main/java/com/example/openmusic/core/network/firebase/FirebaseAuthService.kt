package com.example.openmusic.core.network.firebase

import com.example.openmusic.presentation.register.AuthUser

interface FirebaseAuthService {

    suspend fun login(
        email: String,
        password: String
    ): AuthUser

    suspend fun register(
        email: String,
        password: String
    ): AuthUser

    suspend fun logout()

    suspend fun sendResetEmail(
        email: String
    )

    fun currentUser(): AuthUser?
}