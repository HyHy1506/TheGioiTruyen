package com.example.thegioitruyen.ducviewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import com.example.thegioitruyen.SampleDataStory
import com.example.thegioitruyen.ducdataclass.ChapterDataClass
import com.example.thegioitruyen.ducdataclass.StoryDataClass
import com.example.thegioitruyen.ducutils.getLoremIpsum

class ChapterViewModel (var context: Context): ViewModel() {
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
        return SampleDataStory.getListOfChapter(context).filter { it.idStory==story.idStory }
    }
    fun getAllChaptersByStory(idStory: Int): List<ChapterDataClass> {
        return SampleDataStory.getListOfChapter(context).filter { it.idStory==idStory }
    }
    fun getOneChapter(story: StoryDataClass, idxChapter: Int): ChapterDataClass {
        return SampleDataStory.getListOfChapter(context).get(idxChapter)

    }
    fun getOneExampleChapter(): ChapterDataClass {
        return ChapterDataClass(1,1, getLoremIpsum(context), SampleDataStory.date)

    }
    fun getNextChapterByCurrentChapter(currentChapter: ChapterDataClass?): ChapterDataClass? {
        var tempChapter=getOneExampleChapter()
        var listAllChaptersByStory=getAllChaptersByStory(currentChapter?.idStory?:tempChapter.idStory)
        var idxCurrentChapter = listAllChaptersByStory.indexOf(currentChapter)
        if (listAllChaptersByStory.size > idxCurrentChapter + 1) {
            return listAllChaptersByStory.get(idxCurrentChapter + 1)
        } else {
            return null
        }
    }

    fun getPreviousChapterByCurrentChapter(currentChapter: ChapterDataClass?): ChapterDataClass? {
        var tempChapter=getOneExampleChapter()
        var listAllChaptersByStory=getAllChaptersByStory(currentChapter?.idStory?:tempChapter.idStory)

        var idxCurrentChapter =listAllChaptersByStory.indexOf(currentChapter)
        if (0 <= idxCurrentChapter - 1) {
            return listAllChaptersByStory.get(idxCurrentChapter - 1)
        } else {
            return null
        }
    }
}