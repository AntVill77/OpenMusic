package com.example.openmusic.data.repository

import com.example.openmusic.data.mock.FakeSongs
import com.example.openmusic.domain.model.Song
import com.example.openmusic.domain.repository.SongRepository

class FakeSongRepository : SongRepository {

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
        TODO("Not yet implemented")
    }

    override suspend fun toggleFavorite(id: String) {
        TODO("Not yet implemented")
    }
}