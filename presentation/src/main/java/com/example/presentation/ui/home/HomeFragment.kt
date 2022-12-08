package com.example.presentation.ui.home

import android.os.Bundle
import com.example.presentation.base.BindingFragment
import com.example.presentation.databinding.FragmentHomeBinding
import com.example.presentation.entities.VideoUIEntity
import com.example.presentation.ui.home.adapter.VideoAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : BindingFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate) {

    override val viewModel: HomeViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.getPopularVideos()
    }

    override fun setupView() {
        binding.lifecycleOwner = this
        binding.homeVM = viewModel
        binding.recyclerVideo.adapter = VideoAdapter(this::onItemClick)
        viewModel.getFavourites()
    }

    private fun onItemClick(item: VideoUIEntity) {
        println("click")
        viewModel.insertFavourite(item)
//        findNavController().navigate(
//            HomeFragmentDirections.actionNavigationHomeToPlayVideoFragment(
//                item
//            )
//        )
    }
}