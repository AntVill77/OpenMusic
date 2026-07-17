package com.example.openmusic.data.local.datasource

import com.example.openmusic.data.local.dao.SongDao
import com.example.openmusic.data.local.entity.toDomain
import com.example.openmusic.data.mapper.toEntity
import com.example.openmusic.domain.model.Song
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class SongLocalDataSourceImpl @Inject constructor(
    private val dao: SongDao
) : SongLocalDataSource {

    override fun observeSongs(): Flow<List<Song>> =
        dao.observeSongs().map { entities ->
            entities.map { it.toDomain() }
        }

    override suspend fun getSong(id: String): Song? =
        dao.getSong(id)?.toDomain()

    override suspend fun saveSongs(songs: List<Song>) {
        dao.insertSongs(
            songs.map { it.toEntity() }
        )
    }

    override suspend fun clearSongs() {
        dao.clear()
    }
}