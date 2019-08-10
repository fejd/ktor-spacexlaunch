package com.spacexlaunch.app

import com.spacexlaunch.app.json.LatestLaunch
import kotlinx.coroutines.runBlocking
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class SpaceXRepository {
    private val spaceXApi: SpaceXApi

    init {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        val okHttpClientBuilder = OkHttpClient.Builder().addInterceptor {
            // This open API does not require any headers. This would be the
            // place to add headers for APIs that, for example require an API key.
            it.proceed(it.request().newBuilder().build())
        }
        val retrofit = Retrofit.Builder()
                .baseUrl(SpaceXApi.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClientBuilder.build())
                .build()
        spaceXApi = retrofit.create(SpaceXApi::class.java)
    }

    fun getLatestLaunch(block: suspend (LatestLaunch) -> Unit) {
        runBlocking {
            val response = spaceXApi.getLatestLaunch()
            val result = response.body()
            result?.let {
                block(it)
            }
        }
    }
}