package com.example.thegioitruyen

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.thegioitruyen.databinding.ActivityStoryOverviewBinding
import com.example.thegioitruyen.databinding.ActivityUserHomeBinding

class StoryOverviewActivity : AppCompatActivity() {
    private lateinit var binding: ActivityStoryOverviewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityStoryOverviewBinding.inflate(layoutInflater)
        val view = binding.root
        enableEdgeToEdge()
        setContentView(view)

    }
}