package com.example.data.repository

import com.example.data.RxTrampolineSchedulerRule
import com.example.data.WebserverBaseTest
import com.example.data.api.result_entity.VideoListResult
import com.example.data.api.services.VideoService
import com.example.data.datastore.remote.VideosRemoteDataStore
import com.example.domain.VideosDataStore
import com.example.domain.VideosRepository
import com.example.domain.entities.VideoEntity
import io.reactivex.rxjava3.android.plugins.RxAndroidPlugins
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.observers.TestObserver
import io.reactivex.rxjava3.schedulers.Schedulers
import io.reactivex.rxjava3.subscribers.TestSubscriber
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import retrofit2.HttpException
import java.util.concurrent.TimeUnit

class VideosRepositoryImplTest : WebserverBaseTest() {

    private val api = retrofit.create(VideoService::class.java)
    private val remote: VideosDataStore.Remote = VideosRemoteDataStore(api)
    private val repository: VideosRepository = VideosRepositoryImpl(remote)

//    @Rule
//    @JvmField
//    var testSchedulerRule = RxTrampolineSchedulerRule()

    @Before
    fun start() {
//        RxAndroidPlugins.setInitMainThreadSchedulerHandler {
//            Schedulers.trampoline()
//        }
    }

    @Test
    fun `should fetch movies correctly given 200 response`() {
        mockWebServer.enqueueResponse("response_videos_200.json", 200)
        val response = repository.getPopularVideos(1).blockingFirst()
        assert(response.isNotEmpty())
    }

    @Test
    fun `should given 401 response when missing authorization`() {
        mockWebServer.enqueueResponse("response_videos_401.json", 401)
        val exampleShirtsSubscription = repository
            .getPopularVideos(1)
            .test()
        exampleShirtsSubscription.awaitDone(1000L, TimeUnit.SECONDS)
        exampleShirtsSubscription.assertError {
            it is HttpException && it.code() == 401
        }
    }


    @Test
    fun `should search videos correctly given 200 response`() {
        mockWebServer.enqueueResponse("response_videos_200.json", 200)
        val response = repository.search("", 1)
            .blockingFirst()
        assert(response.isNotEmpty())
    }

    @Test
    fun `should given 401 response when missing authorization search video`() {
        mockWebServer.enqueueResponse("response_videos_401.json", 401)
        val exampleShirtsSubscription = repository
            .search("", 1)
            .test()
        exampleShirtsSubscription.awaitDone(10L, TimeUnit.SECONDS)
        exampleShirtsSubscription.assertError {
            it is HttpException && it.code() == 401
        }
    }

    @Test
    fun testRx() {

    }


    @After
    fun after() {
        mockWebServer.shutdown()
    }
}