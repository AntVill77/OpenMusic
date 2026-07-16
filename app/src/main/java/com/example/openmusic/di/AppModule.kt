package com.example.openmusic.di

import com.example.openmusic.data.repository.FakeSongRepository
import com.example.openmusic.domain.repository.SongRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideSongRepository(): SongRepository {
        return FakeSongRepository()
    }
}
