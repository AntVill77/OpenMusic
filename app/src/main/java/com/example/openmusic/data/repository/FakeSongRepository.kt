package com.example.openmusic.data.repository

import com.example.openmusic.data.mock.FakeSongs
import com.example.openmusic.domain.model.Song
import com.example.openmusic.domain.repository.SongRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class FakeSongRepository : SongRepository {
    override fun observeSongs(): Flow<List<Song>> {
        return flowOf(FakeSongs.songs)
    }

    override suspend fun getSongs(): List<Song> {

        return FakeSongs.songs

    }

    override suspend fun getSong(
        id: String
    ): Song? {

        return FakeSongs.songs.find {

            it.id == id

        }
    }

    override suspend fun search(query: String): List<Song> {
        return FakeSongs.songs.filter {
            it.title.contains(query, ignoreCase = true) ||
                    it.composer.contains(query, ignoreCase = true)
        }
    }

    override suspend fun toggleFavorite(id: String) {
        // No-op for now
    }

    override suspend fun syncSongs() {
        // No-op for now
    }
}