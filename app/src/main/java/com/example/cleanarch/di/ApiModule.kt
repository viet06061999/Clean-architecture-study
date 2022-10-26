package com.example.cleanarch.di

import com.example.data.api.services.VideoService
import org.koin.dsl.module
import retrofit2.Retrofit

val apiModule = module {
    single { get<Retrofit>().create(VideoService::class.java) }
}