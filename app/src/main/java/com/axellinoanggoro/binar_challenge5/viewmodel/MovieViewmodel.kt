package com.axellinoanggoro.binar_challenge5.viewmodel

import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.axellinoanggoro.binar_challenge5.model.GetPopularMovie
import com.axellinoanggoro.binar_challenge5.model.ResultPopularMovie
import com.axellinoanggoro.binar_challenge5.network.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class MovieViewmodel : ViewModel() {
    var liveDataMovie: MutableLiveData<List<ResultPopularMovie>> = MutableLiveData()

    fun callTmdb() {
        ApiClient.instance.getPopularMovie().enqueue(object : Callback<GetPopularMovie> {
            override fun onResponse(
                call: Call<GetPopularMovie>,
                response: Response<GetPopularMovie>
            ) {
                if (response.isSuccessful) {
                    liveDataMovie.postValue(response.body()?.results)
                } else {
                    liveDataMovie.postValue(null)
                }
            }

            override fun onFailure(call: Call<GetPopularMovie>, t: Throwable) {
                liveDataMovie.postValue(null)
            }

        })
    }
}