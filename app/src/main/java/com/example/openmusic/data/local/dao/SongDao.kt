package com.example.openmusic.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.openmusic.data.local.entity.SongEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface SongDao {

    @Query("SELECT * FROM songs ORDER BY title")
    fun observeSongs(): Flow<List<SongEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSongs(
        songs: List<SongEntity>
    )

    @Query("DELETE FROM songs")
    suspend fun clear()

    @Query("SELECT * FROM songs WHERE id=:id")
    suspend fun getSong(id:String): SongEntity?

}