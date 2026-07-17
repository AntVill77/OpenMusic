package com.example.openmusic.data.remote.datasource

import com.example.openmusic.domain.model.Song

interface SongRemoteDataSource {

    suspend fun getSongs(): List<Song>

    suspend fun getSong(id: String): Song?

}