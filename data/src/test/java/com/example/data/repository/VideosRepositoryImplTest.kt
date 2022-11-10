package com.example.data.repository

import com.example.data.WebserverBaseTest
import com.example.data.api.services.VideoService
import com.example.data.datastore.remote.VideosRemoteDataStore
import com.example.domain.VideosDataStore
import com.example.domain.VideosRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Test
import retrofit2.HttpException

@OptIn(ExperimentalCoroutinesApi::class)
class VideosRepositoryImplTest : WebserverBaseTest() {

    private val api = retrofit.create(VideoService::class.java)
    private val remote: VideosDataStore.Remote = VideosRemoteDataStore(api)
    private val repository: VideosRepository = VideosRepositoryImpl(remote)

    @Test
    fun `should fetch movies correctly given 200 response`() = runTest() {
        mockWebServer.enqueueResponse("response_videos_200.json", 200)
        val response = repository.getPopularVideos(1)
        assert(response.isNotEmpty())
    }

    @Test
    fun `should given 401 response when missing authorization`() = runTest {
        mockWebServer.enqueueResponse("response_videos_401.json", 401)
        val response = try {
            repository
                .getPopularVideos(1)
        } catch (e: java.lang.Exception) {
            e
        }
        assert(response is HttpException && response.code() == 401)
    }


    @Test
    fun `should search videos correctly given 200 response`() = runTest {
        mockWebServer.enqueueResponse("response_videos_200.json", 200)
        val response = repository.search("", 1)
        assert(response.isNotEmpty())
    }

    @Test
    fun `should given 401 response when missing authorization search video`() = runTest {
        mockWebServer.enqueueResponse("response_videos_401.json", 401)
        val response = try {
            repository
                .search("", 1)
        } catch (e: java.lang.Exception) {
            e
        }
        assert(response is HttpException && response.code() == 401)
    }
}