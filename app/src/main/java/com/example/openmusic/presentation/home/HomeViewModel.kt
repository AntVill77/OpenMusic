package com.example.openmusic.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.openmusic.domain.usecase.GetSongsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getSongsUseCase: GetSongsUseCase
) : ViewModel() {

    private val _state =
        MutableStateFlow(HomeState())

    val state =
        _state.asStateFlow()

    init {

        loadSongs()

    }

    private fun loadSongs() {

        viewModelScope.launch {

            _state.value =
                _state.value.copy(
                    loading = true
                )

            val songs =
                getSongsUseCase()

            _state.value =
                HomeState(
                    songs = songs,
                    loading = false
                )

        }
    }
}