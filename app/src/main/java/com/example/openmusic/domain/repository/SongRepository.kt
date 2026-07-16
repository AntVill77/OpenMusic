package com.example.openmusic.domain.repository

import com.example.openmusic.domain.model.Song

interface SongRepository {

    suspend fun getSongs(): List<Song>

    suspend fun getSong(id: String): Song?

    suspend fun search(query: String): List<Song>

    suspend fun toggleFavorite(id: String)
}