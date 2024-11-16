package com.example.thegioitruyen.ducviewmodel

import android.R
import android.content.Context
import androidx.lifecycle.ViewModel
import com.example.thegioitruyen.SampleDataStory
import com.example.thegioitruyen.ducdataclass.CommentDataClass
import com.example.thegioitruyen.ducutils.getLoremIpsum

class CommentViewModel(var context: Context): ViewModel() {
    fun getAllComment(): List<CommentDataClass> {
        return SampleDataStory.getListOfComment(context)
    }
    fun getCommentsByUser(idUser:Int): List<CommentDataClass> {
        return SampleDataStory.getListOfComment(context).filter { it.idUser== idUser }
    }
    fun getCommentsByStory(idStory:Int): List<CommentDataClass> {
        return SampleDataStory.getListOfComment(context).filter { it.idStory== idStory }
    }
    fun createUserCommnet(idStory:Int,content:String){
        SampleDataStory.addUserComment(idStory,content, SampleDataStory.date)
    }
    fun getOneExampleComment(): CommentDataClass{
        return CommentDataClass(1,1,1, getLoremIpsum(context), SampleDataStory.date)
    }
}