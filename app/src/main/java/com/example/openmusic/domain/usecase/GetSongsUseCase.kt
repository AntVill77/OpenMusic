package com.example.openmusic.domain.usecase

import com.example.openmusic.domain.repository.SongRepository
import javax.inject.Inject

class GetSongsUseCase @Inject constructor(
    private val repository: SongRepository
) {
    suspend operator fun invoke() = repository.getSongs()
}
