package com.axellinoanggoro.binar_challenge5.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.axellinoanggoro.binar_challenge5.adapter.MovieAdapter
import com.axellinoanggoro.binar_challenge5.databinding.ActivityDetailBinding
import com.axellinoanggoro.binar_challenge5.model.DataPopularMovie
import com.axellinoanggoro.binar_challenge5.model.ResultPopularMovie
import com.bumptech.glide.Glide

class DetailActivity : AppCompatActivity(), MovieAdapter.OnItemClickListener {

    private lateinit var binding : ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val data = intent.getParcelableExtra<DataPopularMovie>("data_detail")
        setViewData(data)
    }

    private fun setViewData(data: DataPopularMovie?) {
        val title = data?.title
        val date = data?.date
        val overview = data?.desc
        val imagepath = data?.image

        binding.detailTitle.text = title
        binding.detailDate.text = date
        binding.detailDsc.text = overview
        Glide.with(this).load("https://image.tmdb.org/t/p/w780$imagepath").into(binding.detailImg)
    }

    override fun onItemClick(data: DataPopularMovie) {
        val move = Intent(this, DetailActivity::class.java)
        move.putExtra("data_detail",data)
        startActivity(move)
    }
}