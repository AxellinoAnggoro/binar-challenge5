package com.axellinoanggoro.binar_challenge5.activity

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.axellinoanggoro.binar_challenge5.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    lateinit var binding: ActivityHomeBinding
    lateinit var pref : SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        pref = this.getSharedPreferences("data_reg", Context.MODE_PRIVATE)
        val showUsername = pref.getString("username", "username")
        binding.homeTv.text = "Welcome $showUsername"
    }
}