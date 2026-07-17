package com.example.openmusic.domain.repository

import com.example.openmusic.data.local.datasource.SongLocalDataSource
import com.example.openmusic.data.remote.datasource.SongRemoteDataSource
import com.example.openmusic.domain.model.Song
import javax.inject.Inject

class SongRepositoryImpl @Inject constructor(

    private val local: SongLocalDataSource,

    private val remote: SongRemoteDataSource

) : SongRepository {
    override fun observeSongs() = local.observeSongs()

    override suspend fun getSongs(): List<Song> {
        TODO("Not yet implemented")
    }

    override suspend fun getSong(id: String) = local.getSong(id)


    override suspend fun search(query: String): List<Song> {
        TODO("Not yet implemented")
    }

    override suspend fun toggleFavorite(id: String) {
        TODO("Not yet implemented")
    }

    override suspend fun syncSongs() {
        val remoteSongs =
            remote.getSongs()

        local.saveSongs(remoteSongs)
    }
}