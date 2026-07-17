package com.example.openmusic.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.openmusic.data.local.entity.FavoriteEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface FavoriteDao {

    @Query(
        "SELECT * FROM favorites"
    )
    fun observeFavorites():
            Flow<List<FavoriteEntity>>

    @Insert(
        onConflict =
            OnConflictStrategy.REPLACE
    )
    suspend fun insert(
        favorite: FavoriteEntity
    )

    @Delete
    suspend fun delete(
        favorite: FavoriteEntity
    )
}