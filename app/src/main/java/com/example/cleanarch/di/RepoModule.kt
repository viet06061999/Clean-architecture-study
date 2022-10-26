package com.example.cleanarch.di

import com.example.data.datastore.remote.VideosRemoteDataStore
import com.example.data.repository.VideosRepositoryImpl
import com.example.domain.VideosDataStore
import com.example.domain.VideosRepository
import org.koin.dsl.module

val repoModule = module {
    single<VideosDataStore.Remote> { VideosRemoteDataStore(get()) }
    single<VideosRepository> { VideosRepositoryImpl(get()) }
}