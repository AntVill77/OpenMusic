package com.example.openmusic.feature.player.domain.usecase

import com.example.openmusic.feature.player.domain.PlayerController
import javax.inject.Inject

class ObservePlayerStateUseCase
@Inject constructor(

    private val controller: PlayerController

) {

    operator fun invoke() =
        controller.playerState

}