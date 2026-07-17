package com.example.openmusic.presentation.splash


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.openmusic.core.sesion.SessionManager
import com.example.openmusic.core.sesion.SessionState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel
@Inject constructor(

    sessionManager: SessionManager

): ViewModel() {
    private val _state = MutableStateFlow<SessionState>(SessionState.Loading)
    val state = _state.asStateFlow()

    init {
        viewModelScope.launch {

            // Tiempo mínimo que permanece el Splash
            delay(2000)

            // Obtener el estado actual de la sesión
           // _state.value = sessionManager.sessionState.value

            // Esperar el primer estado distinto de Loading
            sessionManager.sessionState
                .filter { it !is SessionState.Loading }
                .first()
                .let {
                    _state.value = it
                }
        }
    }

}