package com.example.openmusic.di

import com.example.openmusic.domain.repository.SongRepository
import com.example.openmusic.domain.usecase.GetSongsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    fun provideGetSongsUseCase(
        repository: SongRepository
    ): GetSongsUseCase {

        return GetSongsUseCase(repository)

    }

}