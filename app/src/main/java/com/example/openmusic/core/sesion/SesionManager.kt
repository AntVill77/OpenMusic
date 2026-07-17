package com.example.openmusic.core.sesion

import kotlinx.coroutines.flow.StateFlow

interface SessionManager {

    val sessionState: StateFlow<SessionState>

}