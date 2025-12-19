package com.example.popsa_clone.di

import com.example.popsa_clone.data.remote.PopsaApi
import com.example.popsa_clone.data.repository.HomeRepositoryImpl
import com.example.popsa_clone.domain.HomeRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideHomeRepository(popsaApi: PopsaApi): HomeRepository {
        return HomeRepositoryImpl(popsaApi)
    }
}