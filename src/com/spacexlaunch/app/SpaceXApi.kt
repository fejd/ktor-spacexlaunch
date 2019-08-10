package com.spacexlaunch.app

import com.spacexlaunch.app.json.LatestLaunch
import retrofit2.Response
import retrofit2.http.GET

interface SpaceXApi {
    @GET("launches/latest")
    suspend fun getLatestLaunch(): Response<LatestLaunch>

    companion object {
        const val BASE_URL = "https://api.spacexdata.com/v3/"
    }
}