package com.example.openmusic.presentation.splash


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.openmusic.domain.usecase.GetCurrentUserUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

@HiltViewModel
class SplashViewModel @Inject constructor(

    private val getCurrentUser: GetCurrentUserUseCase

) : ViewModel() {

    private val _state =
        MutableStateFlow(SplashState())

    val state =
        _state.asStateFlow()

    init {

        checkSession()

    }

    private fun checkSession() {

        viewModelScope.launch {

            delay(1500)

            val user =
                getCurrentUser()

            _state.value =
                SplashState(

                    loading = false,

                    destination =

                        if (user == null)

                            SplashDestination.Login

                        else

                            SplashDestination.Home

                )

        }

    }

}