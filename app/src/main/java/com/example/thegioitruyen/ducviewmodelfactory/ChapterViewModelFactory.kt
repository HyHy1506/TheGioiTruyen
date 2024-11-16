package com.example.thegioitruyen.ducviewmodelfactory

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.thegioitruyen.ducviewmodel.ChapterViewModel
import com.example.thegioitruyen.ducviewmodel.ParagraphViewModel

class ChapterViewModelFactory(private var context :Context): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(ChapterViewModel::class.java))
        {
            return ChapterViewModel(context) as T
        }
        throw IllegalArgumentException("unknown view model class")
    }
}