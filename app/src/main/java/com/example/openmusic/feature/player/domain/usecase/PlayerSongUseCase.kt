package com.example.openmusic.feature.player.domain.usecase

import com.example.openmusic.feature.player.domain.PlayerController
import javax.inject.Inject

class PlaySongUseCase
@Inject constructor(

    private val controller: PlayerController

) {

    suspend operator fun invoke(
        songId: String
    ) {

        controller.play(songId)

    }

}