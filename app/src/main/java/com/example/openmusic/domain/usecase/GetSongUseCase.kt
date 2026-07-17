package com.example.openmusic.domain.usecase

import com.example.openmusic.domain.repository.SongRepository

import javax.inject.Inject

class GetSongUseCase
@Inject constructor(

    private val repository:
    SongRepository

){

    suspend operator fun invoke(
        id:String
    )=
        repository.getSong(id)

}