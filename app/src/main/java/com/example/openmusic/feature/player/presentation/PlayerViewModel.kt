package com.example.openmusic.feature.player.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.openmusic.feature.player.domain.PlayerController
import com.example.openmusic.feature.player.domain.usecase.ObservePlayerStateUseCase
import com.example.openmusic.feature.player.domain.usecase.PlaySongUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PlayerViewModel @Inject constructor(

    observePlayerStateUseCase: ObservePlayerStateUseCase,

    private val playSongUseCase: PlaySongUseCase,

    private val playerController: PlayerController

) : ViewModel() {

    val state = observePlayerStateUseCase()

        .stateIn(

            scope = viewModelScope,

            started = SharingStarted.WhileSubscribed(5000),

            initialValue = PlayerUiState()

        )
    fun onEvent(event: PlayerEvent) {

        when (event) {

            is PlayerEvent.Play -> {

                viewModelScope.launch {
                    playSongUseCase(event.song)
                }

            }

            PlayerEvent.Pause -> {

                playerController.pause()

            }

            PlayerEvent.Resume -> {

                playerController.resume()

            }

            PlayerEvent.Stop -> {

                playerController.stop()

            }

            is PlayerEvent.SeekTo -> {

                playerController.seekTo(event.position)

            }

        }

    }

}