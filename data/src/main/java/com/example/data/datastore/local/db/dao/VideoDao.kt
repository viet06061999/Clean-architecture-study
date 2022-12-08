package com.example.data.datastore.local.db.dao

import androidx.room.*
import com.example.data.entities.*
import kotlinx.coroutines.flow.Flow

@Dao
interface VideoDao {
    @Query("SELECT * FROM Video")
    fun getFavourites(): Flow<List<VideoSaveData>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertVideo(video: Video)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertUser(userData: UserData)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertVideoFile(videoFiles: List<VideoFileData>)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertVideoPicture(videoPictures: List<VideoPictureData>)

    @Delete
    fun deleteVideo(video: Video)

    @Delete
    fun deleteUser(userData: UserData)

    @Delete
    fun deleteVideoFile(videoFiles: List<VideoFileData>)

    @Delete
    fun deleteVideoPicture(videoPictures: List<VideoPictureData>)

    suspend fun insertFavourite(videoData: VideoSaveData) {
        insertVideo(videoData.video)
        insertUser(videoData.user)
        insertVideoFile(videoData.videoFiles)
        insertVideoPicture(videoData.videoPictures)
    }

    suspend fun deleteFavourite(videoData: VideoSaveData) {
        deleteUser(videoData.user)
        deleteVideoFile(videoData.videoFiles)
        deleteVideoPicture(videoData.videoPictures)
        deleteVideo(videoData.video)
    }
}