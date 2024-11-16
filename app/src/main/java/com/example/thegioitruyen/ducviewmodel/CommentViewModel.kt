package com.example.thegioitruyen.ducviewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import com.example.thegioitruyen.SampleDataStory
import com.example.thegioitruyen.ducdataclass.CommentDataClass
import com.example.thegioitruyen.ducutils.getImageAvatar
import com.example.thegioitruyen.ducutils.getLoremIpsum
import com.example.thegioitruyen.ducutils.showTestToast

class CommentViewModel(var context: Context): ViewModel() {
    fun checkCommentFromUser(comment: CommentDataClass): Boolean{
        return (comment.idUser== SampleDataStory.idUser)
    }
    fun getDisplayNameUserByComment(comment: CommentDataClass): String{
        return getLoremIpsum(context)
    }
    fun getAvatarUserByComment(comment: CommentDataClass): Int{
        return getImageAvatar(context)
    }
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
        var old =SampleDataStory.getListOfComment(context).size.toString()
        SampleDataStory.addUserComment(idStory,content, SampleDataStory.date)

    }
    fun getOneExampleComment(): CommentDataClass{
        return CommentDataClass(1,1,1, getLoremIpsum(context), SampleDataStory.date)
    }
}