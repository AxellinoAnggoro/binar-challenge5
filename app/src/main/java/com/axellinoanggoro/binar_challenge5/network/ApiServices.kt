package com.axellinoanggoro.binar_challenge5.network

import com.axellinoanggoro.binar_challenge5.model.GetPopularMovie
import retrofit2.Call
import retrofit2.http.GET

interface ApiServices {
    @GET("movie/popular?api_key=3cf1453ff43199b0e878a7e9f7614476&page=1")
    fun getPopularMovie(): Call<GetPopularMovie>
}