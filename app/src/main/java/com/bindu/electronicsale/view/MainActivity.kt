package com.bindu.electronicsale.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bindu.electronicsale.R
import com.bindu.electronicsale.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.televisionBtn.setOnClickListener {
            val intent = Intent(this, TelevisionsActivity::class.java)
            startActivity(intent)
        }

        binding.mobileBtn.setOnClickListener {
            val intent = Intent(this, MobilesActivity::class.java)
            startActivity(intent)
        }

        binding.laptopBtn.setOnClickListener {
            val intent = Intent(this, TelevisionsActivity::class.java)
            startActivity(intent)
        }

        binding.mycartBtn.setOnClickListener {
            val intent = Intent(this, CartActivity::class.java)
            startActivity(intent)
        }

    }
}