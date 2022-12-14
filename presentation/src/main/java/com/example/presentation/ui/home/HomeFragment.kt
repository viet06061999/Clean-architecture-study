package com.example.presentation.ui.home

import androidx.navigation.fragment.findNavController
import com.example.presentation.base.BindingFragment
import com.example.presentation.databinding.FragmentHomeBinding
import com.example.presentation.entities.VideoUIEntity
import com.example.presentation.ui.home.adapter.VideoAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : BindingFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate) {

    override val viewModel: HomeViewModel by viewModel()

    override fun setupView() {
        binding.lifecycleOwner = this
        binding.homeVM = viewModel
        binding.recyclerVideo.adapter = VideoAdapter(this::onItemClick)
    }

    private fun onItemClick(item: VideoUIEntity) {
        findNavController().navigate(
            HomeFragmentDirections.actionNavigationHomeToPlayVideoFragment(
                item
            )
        )
    }
}