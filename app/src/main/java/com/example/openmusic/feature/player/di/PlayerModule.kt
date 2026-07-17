package com.example.openmusic.feature.player.di

import android.content.Context
import com.example.openmusic.feature.player.data.PlayerControllerImpl
import com.example.openmusic.feature.player.domain.PlayerController
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class PlayerModule {

    @Binds
    @Singleton
    abstract fun bindPlayerController(
        impl: PlayerControllerImpl
    ): PlayerController

    companion object {
        @Provides
        @Singleton
        fun provideApplicationContext(
            @ApplicationContext context: Context
        ): Context = context
    }
}