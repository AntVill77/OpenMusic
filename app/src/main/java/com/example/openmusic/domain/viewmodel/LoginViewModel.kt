package com.example.openmusic.domain.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.openmusic.domain.usecase.LoginUseCase
import com.example.openmusic.presentation.login.LoginEvent
import com.example.openmusic.presentation.login.LoginState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(

    private val loginUseCase: LoginUseCase

) : ViewModel() {

    private val _state =
        MutableStateFlow(LoginState())

    val state = _state.asStateFlow()

    fun onEvent(event: LoginEvent) {
        when (event) {
            is LoginEvent.EmailChanged -> {
                _state.update { it.copy(email = event.value) }
            }
            is LoginEvent.PasswordChanged -> {
                _state.update { it.copy(password = event.value) }
            }
            LoginEvent.LoginClicked -> login()
        }
    }

    fun login() {

        viewModelScope.launch {

            _state.update {
                it.copy(loading = true)
            }

            val result =
                loginUseCase(
                    _state.value.email,
                    _state.value.password
                )

            result.fold(

                onSuccess = {

                    // Emitir efecto de navegación
                },

                onFailure = {

                    _state.update {

                        it.copy(
                            loading = false,
                            error = it.error
                        )

                    }

                }

            )

        }

    }

}