package com.example.thegioitruyen.ducviewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.thegioitruyen.SampleDataStory
import com.example.thegioitruyen.ducdataclass.GenreDataClass
import com.example.thegioitruyen.ducdataclass.StoryDataClass

class StoryViewModel: ViewModel() {
    private val _stories= MutableLiveData<List<StoryDataClass>>()

    val stories : LiveData<List<StoryDataClass>> get() =_stories
    init {
        _stories.value= SampleDataStory.getDataList()
    }
    fun getComicStoriesByGenre( genre: GenreDataClass?): List<StoryDataClass>{
        var comicStoryList= SampleDataStory.getDataList().filter { it.isComic==true }
        return comicStoryList
    }
    fun getTextStoriesByGenre( genre: GenreDataClass?): List<StoryDataClass>{
        var comicStoryList= SampleDataStory.getDataList().filter { it.isComic==false }
        return comicStoryList
    }
}