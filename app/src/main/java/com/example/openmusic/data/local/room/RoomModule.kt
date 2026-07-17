package com.example.openmusic.data.local.room

import android.content.Context
import androidx.room.Room
import com.example.openmusic.data.local.database.OpenMusicDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    @Provides
    @Singleton
    fun provideDatabase(
        @ApplicationContext context: Context
    ): OpenMusicDatabase {

        return Room.databaseBuilder(
            context,
            OpenMusicDatabase::class.java,
            "openmusic.db"
        ).build()
    }

    @Provides
    fun provideSongDao(
        db: OpenMusicDatabase
    ) = db.songDao()

}