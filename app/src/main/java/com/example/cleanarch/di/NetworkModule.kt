package com.example.cleanarch.di

import android.util.Log
import com.example.cleanarch.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.ResponseBody
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


val networkModule = module {

    val logTagRequest = "request"
    val logTagResponse = "response"

    fun provideHttpClient(): OkHttpClient {
        val okHttpClientBuilder = OkHttpClient.Builder()
        okHttpClientBuilder.addInterceptor { chain ->
            val original = chain.request()
            val originalHttpUrl = original.url()
            val url = originalHttpUrl.newBuilder()
                .build()

            val requestBuilder: Request.Builder = original.newBuilder()
                .url(url)
            val request: Request = requestBuilder
                .header("Authorization", BuildConfig.API_KEY)
                .build()
            if (BuildConfig.DEBUG) {
                Log.d(logTagRequest, request.headers().toString())
                Log.d(logTagRequest, request.toString())
            }
            val response = chain.proceed(request)
            val bodyString = response.body()?.string()
            if (BuildConfig.DEBUG) Log.d(logTagResponse, bodyString.toString())
            return@addInterceptor response.newBuilder()
                .body(ResponseBody.create(response.body()?.contentType(), bodyString.toString()))
                .build()
        }
        return okHttpClientBuilder.build()
    }

    fun provideRetrofit(client: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .client(client)
            .build()
    }

    single { provideHttpClient() }
    single { provideRetrofit(get()) }
}