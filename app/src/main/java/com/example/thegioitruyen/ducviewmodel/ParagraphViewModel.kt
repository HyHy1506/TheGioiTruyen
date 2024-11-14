package com.example.thegioitruyen.ducviewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import com.example.thegioitruyen.SampleDataStory
import com.example.thegioitruyen.ducdataclass.ChapterDataClass
import com.example.thegioitruyen.ducdataclass.ParagraphDataClass

class ParagraphViewModel: ViewModel() {

    fun getOneParagraphByChapter(context: Context, chapter: ChapterDataClass, pos:Int): ParagraphDataClass?{
        var paragraph= SampleDataStory.getListOfParagraph(context).filter{ it.idChapter==chapter.idChapter  }
            .filter { it.position==pos  }.get(0)?:null
        return paragraph
    }
    fun getAllParagraphsByChapter(context: Context,chapter: ChapterDataClass?): List<ParagraphDataClass>{
        var clone=chapter?: SampleDataStory.getOneChapter()
        var paragraphs= SampleDataStory.getListOfParagraph(context).filter { it.idChapter==clone.idChapter }
        return paragraphs
    }
    fun getNextParagraphsByChapter(context: Context,currentParagraph: ParagraphDataClass): ParagraphDataClass?{
        var paragraph= SampleDataStory.getListOfParagraph(context).firstOrNull{
            it.position==currentParagraph.position+1
        }
        return paragraph
    }
}