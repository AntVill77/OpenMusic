package com.example.openmusic.data.local.datasource

import com.example.openmusic.domain.model.Song
import kotlinx.coroutines.flow.Flow

interface SongLocalDataSource {

    fun observeSongs(): Flow<List<Song>>

    suspend fun getSong(id: String): Song?

    suspend fun saveSongs(songs: List<Song>)

    suspend fun clearSongs()

}