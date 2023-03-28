package com.punyacile.latihan17maret

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.punyacile.latihan17maret.databinding.ActivityRegisterBinding

private lateinit var binding : ActivityRegisterBinding

class Register : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btn2.setOnClickListener {
            startActivity(Intent(this,MainActivity::class.java))
        }
    }
}