package com.example.data.entities

import androidx.room.Embedded
import androidx.room.Relation

data class VideoSaveData(
    @Embedded val video: Video,
    @Relation(parentColumn = "id", entityColumn = "videoId")
    var user: UserData = UserData(),
    @Relation(
        parentColumn = "id",
        entityColumn = "videoId"
    )
    var videoFiles: List<VideoFileData> = arrayListOf(),
    @Relation(
        parentColumn = "id",
        entityColumn = "videoId"
    )
    var videoPictures: List<VideoPictureData> = arrayListOf()
) {


    fun toVideoData(): VideoData {
        return VideoData(
            video.id,
            video.width,
            video.height,
            video.url,
            video.image,
            video.duration,
            user,
            videoFiles,
            videoPictures
        )
    }

    companion object {
        fun fromVideoData(videoData: VideoData): VideoSaveData {
            return VideoSaveData(
                Video(
                    videoData.id,
                    videoData.width,
                    videoData.height,
                    videoData.url,
                    videoData.image,
                    videoData.duration
                ),
                videoData.user,
                videoData.videoFiles,
                videoData.videoPictures
            )
        }
    }
}