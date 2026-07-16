package com.example.openmusic.data.repository

import com.example.openmusic.core.network.firebase.FirebaseAuthService
import com.example.openmusic.presentation.register.AuthUser
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(

    private val service: FirebaseAuthService

) : AuthRepository {

    override suspend fun login(
        email: String,
        password: String
    ): Result<AuthUser> {

        return runCatching {

            service.login(
                email,
                password
            )

        }

    }

    override suspend fun register(
        email: String,
        password: String
    ): Result<AuthUser> {
        TODO("Not yet implemented")
    }

    override suspend fun logout() {
        TODO("Not yet implemented")
    }

    override suspend fun sendPasswordReset(email: String) {
        TODO("Not yet implemented")
    }

    override fun currentUser(): AuthUser? {
        TODO("Not yet implemented")
    }

}