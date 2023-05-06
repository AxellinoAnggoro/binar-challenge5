package com.axellinoanggoro.binar_challenge5.activity

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.axellinoanggoro.binar_challenge5.databinding.ActivityProfileBinding
import com.google.firebase.auth.FirebaseAuth

class ProfileActivity : AppCompatActivity() {
    lateinit var binding: ActivityProfileBinding
    lateinit var pref: SharedPreferences
    lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        pref = this.getSharedPreferences("data_reg", Context.MODE_PRIVATE)

        binding.profileUpdateBtn.setOnClickListener {
            val getUsername = binding.profileUsername.text.toString()
            val save = pref.edit()
            save.putString("username", getUsername)
            save.apply()
            startActivity(Intent(this, HomeActivity::class.java))
            Toast.makeText(this, "Profile Update Success", Toast.LENGTH_SHORT).show()
            finish()
        }

        binding.profileLogoutBtn.setOnClickListener {
            auth = FirebaseAuth.getInstance()
            auth.signOut()
            Toast.makeText(this, "Logout Success", Toast.LENGTH_SHORT).show()
            startActivity(Intent(this, LoginActivity::class.java))
        }
    }
}