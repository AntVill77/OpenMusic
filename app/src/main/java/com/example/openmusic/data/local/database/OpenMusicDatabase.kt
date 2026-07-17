package com.example.openmusic.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.openmusic.data.local.entity.CategoryEntity
import com.example.openmusic.data.local.entity.FavoriteEntity
import com.example.openmusic.data.local.entity.SongEntity
import com.example.openmusic.data.local.dao.FavoriteDao
import com.example.openmusic.data.local.dao.SongDao

@Database(
    entities = [

        SongEntity::class,

        FavoriteEntity::class,

        CategoryEntity::class

    ],

    version = 1,

    exportSchema = true
)
abstract class OpenMusicDatabase :
    RoomDatabase() {

    abstract fun songDao(): SongDao

    abstract fun favoriteDao(): FavoriteDao

}