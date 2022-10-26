package com.example.presentation.binding

import android.net.Uri
import androidx.databinding.BindingAdapter
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.ui.StyledPlayerView

@BindingAdapter("videoPlayerUrl")
fun loadVideoPlay(videoView: StyledPlayerView, url: String) {
    val uri: Uri = Uri.parse(url)
    val player = ExoPlayer.Builder(videoView.context).build()
    videoView.player = player
    val mediaItem = MediaItem.fromUri(uri)
    player.setMediaItem(mediaItem)
    player.prepare()
    player.play()
}