package com.example.openmusic.di

import com.example.openmusic.core.network.firebase.FirebaseSessionManager
import com.example.openmusic.core.sesion.SessionManager
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module

@InstallIn(
    SingletonComponent::class
)

abstract class SessionModule {

    @Binds

    @Singleton

    abstract fun bindSessionManager(

        impl: FirebaseSessionManager

    ): SessionManager

}