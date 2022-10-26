package com.example.presentation.binding

import android.net.Uri
import android.widget.MediaController
import android.widget.VideoView
import androidx.databinding.BindingAdapter

@BindingAdapter("videoUrl")
fun loadImage(videoView: VideoView, url: String) {
    val uri: Uri = Uri.parse(url)
    videoView.setVideoURI(uri)
    val mediaController = MediaController(videoView.context)
    mediaController.setAnchorView(videoView)
    mediaController.setMediaPlayer(videoView)
    videoView.setMediaController(mediaController)
    videoView.requestFocus()
    videoView.start()
}