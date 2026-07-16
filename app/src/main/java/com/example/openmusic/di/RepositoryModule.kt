package com.example.openmusic.di

import com.example.openmusic.core.network.firebase.FirebaseAuthService
import com.example.openmusic.core.network.firebase.FirebaseAuthServiceImpl
import com.example.openmusic.data.repository.AuthRepository
import com.example.openmusic.data.repository.AuthRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindAuthRepository(
        authRepositoryImpl: AuthRepositoryImpl
    ): AuthRepository

    @Binds
    @Singleton
    abstract fun bindFirebaseAuthService(
        firebaseAuthServiceImpl: FirebaseAuthServiceImpl
    ): FirebaseAuthService
}
