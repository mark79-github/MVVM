package com.martinbg.mvvm

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.martinbg.mvvm.databinding.ActivityNextBinding

class NextActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNextBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNextBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}