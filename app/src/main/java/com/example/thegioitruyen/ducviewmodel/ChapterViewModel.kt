package com.example.thegioitruyen.ducviewmodel

import androidx.lifecycle.ViewModel
import com.example.thegioitruyen.SampleDataStory
import com.example.thegioitruyen.ducdataclass.ChapterDataClass
import com.example.thegioitruyen.ducdataclass.StoryDataClass

class ChapterViewModel : ViewModel() {

    fun getAllChaptersByStory(story: StoryDataClass): List<ChapterDataClass> {
        return SampleDataStory.getListOfChapter()
    }
    fun getOneChapter(story: StoryDataClass,chapterID:Int): ChapterDataClass{
        return SampleDataStory.getListOfChapter().get(0)

    }
}