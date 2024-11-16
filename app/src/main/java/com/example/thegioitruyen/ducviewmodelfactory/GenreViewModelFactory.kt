package com.example.thegioitruyen.ducviewmodelfactory

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.thegioitruyen.ducviewmodel.GenreViewModel
import com.example.thegioitruyen.ducviewmodel.ParagraphViewModel

class GenreViewModelFactory (private var context :Context): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(GenreViewModel::class.java))
        {
            return GenreViewModel(context) as T
        }
        throw IllegalArgumentException("unknown view model class")
    }
}