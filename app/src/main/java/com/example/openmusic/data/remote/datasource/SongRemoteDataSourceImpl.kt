package com.example.openmusic.data.remote.datasource

import com.example.openmusic.core.network.firebase.SongFirestoreService
import com.example.openmusic.data.mapper.toDomain
import com.example.openmusic.domain.model.Song
import javax.inject.Inject

class SongRemoteDataSourceImpl @Inject constructor(
    private val service: SongFirestoreService
) : SongRemoteDataSource {

    override suspend fun getSongs(): List<Song> =
        service.getSongs()
            .map { it.toDomain() }

    override suspend fun getSong(id: String): Song? =
        getSongs().firstOrNull {
            it.id == id
        }
}