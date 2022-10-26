package com.example.cleanarch.di

import com.example.cleanarch.common.AsyncTransformer
import com.example.domain.common.Transformer
import com.example.domain.usecase.GetPopularVideo
import com.example.presentation.ui.home.HomeViewModel
import org.koin.dsl.module

val appModule = module {
    single<GetPopularVideo> { GetPopularVideo(AsyncTransformer(), get()) }
    single<HomeViewModel> { HomeViewModel(get()) }
}