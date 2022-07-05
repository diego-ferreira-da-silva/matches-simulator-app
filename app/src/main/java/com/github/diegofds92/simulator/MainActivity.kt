package com.github.diegofds92.simulator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.github.diegofds92.simulator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        //val tvHello = findViewById<TextView>(R.id.tvHello)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}