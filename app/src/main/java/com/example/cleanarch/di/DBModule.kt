package com.example.cleanarch.di

import androidx.room.Room
import com.example.data.datastore.local.db.app_database.AppDatabase
import com.example.data.datastore.local.db.dao.VideoDao
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module


val dbModule = module {

    val dbName = "video_clean"

    single {
        Room.databaseBuilder(
            androidContext(),
            AppDatabase::class.java,
            dbName
        ).build()
    }

    single<VideoDao> {
        val database = get<AppDatabase>()
        database.videoDao()
    }
}