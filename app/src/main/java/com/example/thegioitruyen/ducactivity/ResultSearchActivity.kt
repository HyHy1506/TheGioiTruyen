package com.example.thegioitruyen.ducactivity

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.thegioitruyen.SampleDataStory
import com.example.thegioitruyen.databinding.ActivityResultSearchBinding
import com.example.thegioitruyen.ducadapter.CardStoryItem_Adapter

class ResultSearchActivity : AppCompatActivity() {
    private lateinit var binding: ActivityResultSearchBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding= ActivityResultSearchBinding.inflate(layoutInflater)
        val view =binding.root
        enableEdgeToEdge()
        setContentView(view)

        var cardStoryAdapter= CardStoryItem_Adapter(view.context,ArrayList(SampleDataStory.getDataList()))
        var recyclerView: RecyclerView=binding.recyclerStoriesResultSearch
        recyclerView.adapter=cardStoryAdapter
        recyclerView.layoutManager= GridLayoutManager(view.context,3, LinearLayoutManager.VERTICAL,false)
        //recyclerView.setHasFixedSize(true)
        binding.btnBackResultSearch.setOnClickListener{
            finish()
        }
    }
}