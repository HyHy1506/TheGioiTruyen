package com.example.thegioitruyen.ducviewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import com.example.thegioitruyen.SampleDataStory
import com.example.thegioitruyen.ducdataclass.DucCommentDataClass
import com.example.thegioitruyen.ducutils.getImageAvatar
import com.example.thegioitruyen.ducutils.getLoremIpsum

class DucCommentViewModel(var context: Context): ViewModel() {
    fun checkCommentFromUser(comment: DucCommentDataClass): Boolean{
        return (comment.idUser== SampleDataStory.idUser)
    }
    fun getDisplayNameUserByComment(comment: DucCommentDataClass): String{
        return getLoremIpsum(context)
    }
    fun getAvatarUserByComment(comment: DucCommentDataClass): Int{
        return getImageAvatar(context)
    }
    fun getAllComment(): List<DucCommentDataClass> {
        return SampleDataStory.getListOfComment(context)
    }
    fun getCommentsByUser(idUser:Int): List<DucCommentDataClass> {
        return SampleDataStory.getListOfComment(context).filter { it.idUser== idUser }
    }
    fun getCommentsByStory(idStory:Int): List<DucCommentDataClass> {
        return SampleDataStory.getListOfComment(context).filter { it.idStory== idStory }
    }
    fun createUserCommnet(idStory:Int,content:String){
        var old =SampleDataStory.getListOfComment(context).size.toString()
        SampleDataStory.addUserComment(idStory,content, SampleDataStory.date)

    }
    fun getOneExampleComment(): DucCommentDataClass{
        return DucCommentDataClass(1,1,1, getLoremIpsum(context), SampleDataStory.date)
    }
}