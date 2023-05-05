package com.axellinoanggoro.binar_challenge5.network

import com.axellinoanggoro.binar_challenge5.model.GetPopularMovie
import com.axellinoanggoro.binar_challenge5.model.ResultPopularMovie
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiServices {
    @GET("movie/popular")
    fun getPopularMovie(
        @Query("api_key") API_KEY: String,
        @Query("page") PAGE: Int
    ): Call<GetPopularMovie<ResultPopularMovie>>
}