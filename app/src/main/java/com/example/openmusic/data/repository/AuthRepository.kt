package com.example.openmusic.data.repository

import com.example.openmusic.presentation.register.AuthUser

interface AuthRepository {

    suspend fun login(
        email: String,
        password: String
    ): Result<AuthUser>

    suspend fun register(
        email: String,
        password: String
    ): Result<AuthUser>

    suspend fun logout()

    suspend fun sendPasswordReset(
        email: String
    )

    fun currentUser(): AuthUser?
}