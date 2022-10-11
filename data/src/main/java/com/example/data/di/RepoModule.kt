package com.example.data.di

import com.example.data.Impl
import com.example.domain.VideosRepository
import org.koin.dsl.module

val repoModule = module {
    single<VideosRepository> { Impl() }
}