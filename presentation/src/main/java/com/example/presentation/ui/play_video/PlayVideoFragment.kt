package com.example.presentation.ui.play_video

import android.content.pm.ActivityInfo
import androidx.navigation.fragment.navArgs
import com.example.presentation.base.BindingFragment
import com.example.presentation.databinding.FragmentPlayVideoBinding
import com.example.presentation.ui.home.HomeViewModel
import com.google.android.exoplayer2.ui.StyledPlayerView.ControllerVisibilityListener
import org.koin.androidx.viewmodel.ext.android.viewModel


class PlayVideoFragment :
    BindingFragment<FragmentPlayVideoBinding>(FragmentPlayVideoBinding::inflate) {
    override val viewModel by viewModel<HomeViewModel>()

    private val args by navArgs<PlayVideoFragmentArgs>()

    override fun onResume() {
        super.onResume()
        requireActivity().requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
        binding.playerView.setControllerVisibilityListener(ControllerVisibilityListener {
            binding.btnClose.visibility = it
        })
    }

    override fun setupView() {
        binding.url = args.video.videoFiles.first().link

        binding.btnClose.setOnClickListener {
            requireActivity().onBackPressedDispatcher.onBackPressed()
        }
    }

    override fun onStop() {
        super.onStop()
        binding.playerView.setControllerVisibilityListener(null as ControllerVisibilityListener?)
    }

    override fun onDestroy() {
        super.onDestroy()
        activity?.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
    }
}