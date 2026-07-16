package com.example.openmusic.core.network.firebase

import com.example.openmusic.presentation.register.AuthUser
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class FirebaseAuthServiceImpl @Inject constructor(

    private val auth: FirebaseAuth

) : FirebaseAuthService {

    override suspend fun login(
        email: String,
        password: String
    ): AuthUser {

        val result =
            auth.signInWithEmailAndPassword(
                email,
                password
            ).await()

        val user = requireNotNull(result.user)

        return AuthUser(
            uid = user.uid,
            email = user.email
        )
    }

    override suspend fun register(
        email: String,
        password: String
    ): AuthUser {
        TODO("Not yet implemented")
    }

    override suspend fun logout() {
        TODO("Not yet implemented")
    }

    override suspend fun sendResetEmail(email: String) {
        TODO("Not yet implemented")
    }

    override fun currentUser(): AuthUser? {
        TODO("Not yet implemented")
    }

}