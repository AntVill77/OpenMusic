package com.example.openmusic.feature.player.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.openmusic.domain.model.Song
import com.example.openmusic.feature.player.domain.usecase.ObservePlayerStateUseCase
import com.example.openmusic.feature.player.domain.usecase.PlaySongUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class PlayerViewModel @Inject constructor(

    observePlayerState: ObservePlayerStateUseCase,

    private val playSong: PlaySongUseCase

) : ViewModel() {

    val state = observePlayerState()

        .stateIn(

            viewModelScope,

            SharingStarted.WhileSubscribed(5000),

            PlayerUiState()

        )

    suspend fun play(song: Song) {

        playSong(song)

    }

}