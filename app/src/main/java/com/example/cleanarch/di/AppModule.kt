package com.example.cleanarch.di

import com.example.presentation.VM
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel<VM> { VM(get()) }
}