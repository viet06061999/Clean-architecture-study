package com.example.data.datastore.local.db.app_database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.data.datastore.local.db.dao.VideoDao
import com.example.data.entities.UserData
import com.example.data.entities.Video
import com.example.data.entities.VideoFileData
import com.example.data.entities.VideoPictureData

@Database(
    entities = [Video::class, UserData::class, VideoFileData::class, VideoPictureData::class],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun videoDao(): VideoDao
}