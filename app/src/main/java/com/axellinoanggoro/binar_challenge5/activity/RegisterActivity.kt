package com.axellinoanggoro.binar_challenge5.activity

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import com.axellinoanggoro.binar_challenge5.databinding.ActivityRegisterBinding
import com.google.firebase.auth.FirebaseAuth

class RegisterActivity : AppCompatActivity() {
    lateinit var binding: ActivityRegisterBinding
    lateinit var auth : FirebaseAuth
    lateinit var pref: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.registerLogin.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }

        auth = FirebaseAuth.getInstance()
        pref = this.getSharedPreferences("data_reg", Context.MODE_PRIVATE)


        binding.registerBtn.setOnClickListener {
            var email = binding.registerEmail.text.toString()
            var password = binding.registerPassword.text.toString()
            val getUsername = binding.registerUsername.text.toString()



            if (password.isEmpty()){
                binding.registerPassword.error = "Password still empty"
                binding.registerPassword.requestFocus()
                return@setOnClickListener
            }

            firebaseRegisterAuth(email, password)
            val save = pref.edit()
            save.putString("username",getUsername)
            save.apply()
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }
    }

    private fun firebaseRegisterAuth(email: String, password: String) {
        auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(this){
            if (it.isSuccessful){
                Toast.makeText(this, "Register Success", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this, "${it.exception?.message}", Toast.LENGTH_SHORT).show()
            }
        }
    }
}