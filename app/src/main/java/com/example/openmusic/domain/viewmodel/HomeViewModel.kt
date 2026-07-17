package com.example.openmusic.domain.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.openmusic.domain.usecase.ObserveSongsUseCase
import com.example.openmusic.feature.home.HomeState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(

    private val observeSongs:
    ObserveSongsUseCase

) : ViewModel() {

    private val _state =
        MutableStateFlow(HomeState())

    val state =
        _state.asStateFlow()

    init {

        observe()

    }

    private fun observe() {

        observeSongs()

            .onEach { songs ->

                _state.update {

                    it.copy(

                        songs = songs,

                        loading = false

                    )

                }

            }

            .launchIn(viewModelScope)

    }

}