package com.example.presentation.ui.home.compose

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.bumptech.glide.signature.MediaStoreSignature
import com.example.presentation.entities.VideoUIEntity
import com.example.presentation.ui.home.HomeViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragmentCompose : Fragment() {

    val viewModel: HomeViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.getPopularVideos()
        viewModel.getPopularVideos()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        println("setcontent")
        return ComposeView(requireContext()).apply {
            setContent {
                setViewCompositionStrategy(
                    ViewCompositionStrategy.DisposeOnLifecycleDestroyed(
                        lifecycle
                    )
                )
                MaterialTheme() {
                    VideoList()
                }
            }
        }
    }

    @Composable
    fun VideoList() {
        val videos = viewModel.videos.observeAsState().value ?: emptyList()
        LazyColumn {
            items(videos, key = { video -> video.id }) { videoUI ->
                VideoRow(videoUI)
            }
        }
    }

    @Composable
    fun VideoRow(video: VideoUIEntity) {
        val requestManager = rememberRequestManager()
        Row() {
            VideoView(
                item = video, requestManager = requestManager, modifier = Modifier.fillMaxSize()
            )
        }
    }


    @Composable
    private fun rememberRequestManager() =
        LocalContext.current.let { remember(it) { Glide.with(it) } }

    private fun VideoUIEntity.signature() = MediaStoreSignature("", -1, 0)

    @OptIn(ExperimentalGlideComposeApi::class)
    @Composable
    fun VideoView(item: VideoUIEntity, requestManager: RequestManager, modifier: Modifier) {
        val signature = item.signature()

        GlideImage(
            model = item.image,
            contentDescription = item.user,
            modifier = modifier,
        ) {
            it.thumbnail(
                    requestManager.asDrawable().load(item.image).signature(signature)
                        .override(THUMBNAIL_DIMENSION)
                ).signature(signature)
        }
    }

    companion object {
        private const val THUMBNAIL_DIMENSION = 50
    }
}