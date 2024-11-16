package com.example.thegioitruyen.ducviewmodelfactory

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.thegioitruyen.ducviewmodel.CommentViewModel
import com.example.thegioitruyen.ducviewmodel.ParagraphViewModel

class CommentViewModelFactory (private var context :Context): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(CommentViewModel::class.java))
        {
            return CommentViewModel(context) as T
        }
        throw IllegalArgumentException("unknown view model class")
    }
}