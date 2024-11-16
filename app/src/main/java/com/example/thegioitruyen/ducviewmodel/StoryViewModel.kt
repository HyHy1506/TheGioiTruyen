package com.example.thegioitruyen.ducviewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.thegioitruyen.SampleDataStory
import com.example.thegioitruyen.ducdataclass.GenreDataClass
import com.example.thegioitruyen.ducdataclass.StoryDataClass
import com.example.thegioitruyen.ducutils.getLoremIpsum
import com.example.thegioitruyen.ducutils.getLoremIpsumLong
import com.example.thegioitruyen.R
class StoryViewModel(var context: Context): ViewModel() {
    private val _stories= MutableLiveData<List<StoryDataClass>>()

//    val stories : LiveData<List<StoryDataClass>> get() =_stories
//    init {
//        _stories.value= SampleDataStory.getDataList(this)
//    }
    fun getComicStoriesByGenre( genre: GenreDataClass?): List<StoryDataClass>{
        var comicStoryList= SampleDataStory.getDataList(context).filter { it.isComic==true }
        return comicStoryList
    }
    fun getTextStoriesByGenre(genre: GenreDataClass?): List<StoryDataClass>{
        var comicStoryList= SampleDataStory.getDataList(context).filter { it.isComic==false }
        return comicStoryList
    }
    fun getTextStories( ): List<StoryDataClass>{
        var comicStoryList= SampleDataStory.getDataList(context).filter { it.isComic==false }
        return comicStoryList
    }
    fun getComicStories( ): List<StoryDataClass>{
        var comicStoryList= SampleDataStory.getDataList(context ).filter { it.isComic==true }
        return comicStoryList
    }
    fun getStoriesByQuery(query: String,isComic: Boolean): List<StoryDataClass>{
        var comicStoryList= SampleDataStory.getDataList(context).filter { it.isComic==isComic }
            .filter { it.title.lowercase().contains(query.lowercase(),true) }
        return comicStoryList
    }
    fun getOneExampleStory(): StoryDataClass{
        return StoryDataClass(1, getLoremIpsum(context),getLoremIpsum(context),
            getLoremIpsumLong(context),R.drawable.a1,R.drawable.a4, SampleDataStory.date,4f,true)

    }
}