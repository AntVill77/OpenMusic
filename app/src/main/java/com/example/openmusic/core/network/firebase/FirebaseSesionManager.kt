package com.example.openmusic.core.network.firebase

import com.example.openmusic.core.sesion.SessionManager
import com.example.openmusic.core.sesion.SessionState
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class FirebaseSessionManager @Inject constructor(

    private val firebaseAuth: FirebaseAuth,

) : SessionManager{

    private val _sessionState =
        MutableStateFlow<SessionState>(
            SessionState.Loading
        )

    override val sessionState: StateFlow<SessionState> =
        _sessionState.asStateFlow()

    init {

        firebaseAuth.addAuthStateListener { auth ->

            val user = auth.currentUser

            _sessionState.value =
                if (user == null) {

                    SessionState.Unauthenticated

                } else {

                    SessionState.Authenticated(

                        uid = user.uid,

                        email = user.email

                    )

                }
        }
    }
}