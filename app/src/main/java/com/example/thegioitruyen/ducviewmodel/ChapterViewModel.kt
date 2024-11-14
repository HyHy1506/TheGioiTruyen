package com.example.thegioitruyen.ducviewmodel

import androidx.lifecycle.ViewModel
import com.example.thegioitruyen.SampleDataStory
import com.example.thegioitruyen.ducdataclass.ChapterDataClass
import com.example.thegioitruyen.ducdataclass.StoryDataClass

class ChapterViewModel : ViewModel() {
    var isFirstLoadChapter: Boolean = true
    var mainChapter: ChapterDataClass? = null
    var nextChapter: ChapterDataClass? = null
    var previousChapter: ChapterDataClass? = null
    fun setPreMainNextChapter(mChapter: ChapterDataClass?,pChapter: ChapterDataClass?,
                              nChapter: ChapterDataClass?){
        mainChapter=mChapter
        previousChapter=pChapter
        nextChapter=nChapter
    }
    fun getAllChaptersByStory(story: StoryDataClass): List<ChapterDataClass> {
        return SampleDataStory.getListOfChapter()
    }

    fun getOneChapter(story: StoryDataClass, idxChapter: Int): ChapterDataClass {
        return SampleDataStory.getListOfChapter().get(idxChapter)

    }

    fun getNextChapterByCurrentChapter(currentChapter: ChapterDataClass?): ChapterDataClass? {
        var idxCurrentChapter = SampleDataStory.getListOfChapter().indexOf(currentChapter)
        if (SampleDataStory.getListOfChapter().size > idxCurrentChapter + 1) {
            return SampleDataStory.getListOfChapter().get(idxCurrentChapter + 1)
        } else {
            return null
        }
    }

    fun getPreviousChapterByCurrentChapter(currentChapter: ChapterDataClass?): ChapterDataClass? {
        var idxCurrentChapter = SampleDataStory.getListOfChapter().indexOf(currentChapter)
        if (0 <= idxCurrentChapter - 1) {
            return SampleDataStory.getListOfChapter().get(idxCurrentChapter - 1)
        } else {
            return null
        }
    }
}