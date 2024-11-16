package com.example.thegioitruyen.ducviewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.thegioitruyen.SampleDataStory
import com.example.thegioitruyen.ducdataclass.GenreDataClass

class GenreViewModel(var context: Context): ViewModel() {
    private val _genres= MutableLiveData<List<GenreDataClass>>()
//    val genres:LiveData<List<GenreDataClass>> get() =_genres
//    init {
//        _genres.value= SampleDataStory.getListOfGenre()
//    }
    fun getAllGenres(): List<GenreDataClass>{
        return SampleDataStory.getListOfGenre(context)
    }

}