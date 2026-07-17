package com.example.openmusic.domain.usecase

import com.example.openmusic.domain.repository.SongRepository
import javax.inject.Inject

class ObserveSongsUseCase @Inject constructor(

    private val repository: SongRepository

) {

    operator fun invoke() =
        repository.observeSongs()

}