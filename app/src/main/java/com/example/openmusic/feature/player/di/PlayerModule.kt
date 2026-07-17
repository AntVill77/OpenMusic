package com.example.openmusic.feature.player.di

import com.example.openmusic.feature.player.data.PlayerControllerImpl
import com.example.openmusic.feature.player.domain.PlayerController
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
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

}