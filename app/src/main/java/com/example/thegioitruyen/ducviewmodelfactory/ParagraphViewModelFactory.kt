package com.example.thegioitruyen.ducviewmodelfactory

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.thegioitruyen.ducviewmodel.ParagraphViewModel
import com.example.thegioitruyen.ducviewmodel.StoryViewModel

class ParagraphViewModelFactory (private var context :Context): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(ParagraphViewModel::class.java))
        {
            return ParagraphViewModel(context) as T
        }
        throw IllegalArgumentException("unknown view model class")
    }
}