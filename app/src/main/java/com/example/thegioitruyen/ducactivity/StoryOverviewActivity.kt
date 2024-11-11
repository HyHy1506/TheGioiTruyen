package com.example.thegioitruyen.ducactivity

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.thegioitruyen.R
import com.example.thegioitruyen.SampleDataStory
import com.example.thegioitruyen.databinding.ActivityStoryOverviewBinding
import com.example.thegioitruyen.ducdataclass.StoryDataClass
import com.example.thegioitruyen.ducutils.changeBackgroundTintColorByScore

class StoryOverviewActivity : AppCompatActivity() {
    private lateinit var binding: ActivityStoryOverviewBinding
    private lateinit var storyInfo: StoryDataClass
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityStoryOverviewBinding.inflate(layoutInflater)
        val view = binding.root
        enableEdgeToEdge()
        setContentView(view)



       loadInfoStory()
        generateChapter()
        setButton()
    }
    fun loadInfoStory(){
        storyInfo=intent.getSerializableExtra(resources.getString(R.string.key_storyInfo)) as StoryDataClass

        binding.txtTitleStoryStoryOverview.text=storyInfo.title
        binding.txtAuthorStoryStoryOverview.text=storyInfo.author
        binding.txtDescriptionStoryStoryOverview.text=storyInfo.description
        binding.imgStoryStoryOverview.setImageResource(storyInfo.imgURL)
        binding.imgBackgroundStoryStoryOverview.setImageResource(storyInfo.backgroundImageURL)
        binding.txtScoreStoryStoryOverview.text=storyInfo.score.toString()
        binding.txtScoreStoryStoryOverview.changeBackgroundTintColorByScore(storyInfo.score)

    }
    fun generateChapter(){
        for (item in SampleDataStory.getListOfChapter()) {
            // Inflate each item view
            val itemView = LayoutInflater.from(this)
                .inflate(R.layout.list_item_chapter_story_overview_layout, binding.lineaerlistChapterStoryOverview, false)

            // Set up itemView data if needed
            val titleTextView = itemView.findViewById<TextView>(R.id.txtTitleChapter_listItemStoryOverview_layout)
            val idChapterTextView = itemView.findViewById<TextView>(R.id.txtIDChapter_listItemStoryOverview_layout)
            val dateCreatedTextView = itemView.findViewById<TextView>(R.id.txtDateCreatedChapter_listItemStoryOverview_layout)
            val btn=itemView.findViewById<LinearLayout>(R.id.btn_listItemStoryOverview_layout)
            titleTextView.text = item.title
            idChapterTextView.text = item.idChapter.toString()
            dateCreatedTextView.text = item.dateCreated.toString()
            btn.setOnClickListener{
                var intent= Intent(this, ChapterActivity::class.java)
                startActivity(intent)
            }
            // Add itemView to the container
            binding.lineaerlistChapterStoryOverview.addView(itemView)
        }
    }
    fun setButton(){
        binding.btnBackSotryOverview.setOnClickListener{
            finish()
        }
    }
}