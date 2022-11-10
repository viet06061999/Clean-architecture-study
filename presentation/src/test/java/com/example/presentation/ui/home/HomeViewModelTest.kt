package com.example.presentation.ui.home

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.domain.usecase.GetPopularVideo
import com.example.presentation.base.MainDispatcherRule
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Rule
import org.junit.Test

class HomeViewModelTest {
    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()

    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    private val getPopularVideo: GetPopularVideo = mockk()
    var viewModel: HomeViewModel = HomeViewModel(getPopularVideo)


    @Test
    fun `get videos empty`() = runTest {
//        coEvery {
//            getPopularVideo(1)
//        } returns emptyList()
//        viewModel.getPopularVideos()
//        advanceUntilIdle()
//
//        assert(viewModel.videos.value?.isEmpty() == true)
    }

    @Test
    fun `get list videos return 2 videos`() = runTest {
//        coEvery {
//            getPopularVideo(1)
//        } returns listOf(VideoEntity(), VideoEntity())
//        viewModel.getPopularVideos()
//        advanceUntilIdle()
//
//        assert(viewModel.videos.value?.isEmpty() == false)
    }
}