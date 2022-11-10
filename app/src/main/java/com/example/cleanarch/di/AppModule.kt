package com.example.cleanarch.di

import com.example.domain.usecase.GetPopularVideo
import com.example.presentation.ui.home.HomeViewModel
import org.koin.dsl.module

val appModule = module {
    single<GetPopularVideo> { GetPopularVideo(get()) }
    single<HomeViewModel> { HomeViewModel(get()) }
}