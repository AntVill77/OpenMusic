package com.example.openmusic.domain.repository

import com.example.openmusic.domain.model.Song
import kotlinx.coroutines.flow.Flow

interface SongRepository {

    fun observeSongs(): Flow<List<Song>>

    suspend fun getSongs(): List<Song>

    suspend fun getSong(id: String): Song?

    suspend fun search(query: String): List<Song>

    suspend fun toggleFavorite(id: String)

    suspend fun syncSongs()
}