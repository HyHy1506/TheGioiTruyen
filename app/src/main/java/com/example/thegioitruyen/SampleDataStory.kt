package com.example.thegioitruyen

import android.content.Context
import com.example.thegioitruyen.ducdataclass.StoryDataClass
import com.example.thegioitruyen.ducdataclass.ChapterDataClass
import com.example.thegioitruyen.ducdataclass.GenreDataClass
import com.example.thegioitruyen.ducdataclass.ParagraphDataClass
import com.example.thegioitruyen.ducutils.getLoremIpsumLong
import com.example.thegioitruyen.ducviewmodel.ParagraphViewModel

object SampleDataStory {
    private val dataList= mutableListOf<StoryDataClass>()
    private val listOfGenre = mutableListOf<GenreDataClass>()
    private val listOfChapter = mutableListOf<ChapterDataClass>()
    private val listOfParagraph = mutableListOf<ParagraphDataClass>()

    //-----------------------------------------------------

    fun addData(data : StoryDataClass){
        dataList.add(data)
    }
    fun getDataList(): List<StoryDataClass>{
        dataList.clear()
        generateData()
        return dataList
    }
    private fun generateData(){
        val titleList = arrayOf(
            "Cau chuyen", "Xua kia", "Muon Thua Khac Ghi Nao", "Ai oi3",
            "Ai oi1", "Ai oi3", "Ai oi1", "Ai oi2"
        )
        val authorList = arrayOf(
            "Tran van A", "To B", "Luong C", "Dira", "Eric", "Fuka", "Gahe", "Hios"
        )
        val dateList = arrayOf(
            "11/10/2024", "11/10/2024", "11/10/2024", "11/10/2024", "11/10/2024",
            "11/10/2024", "11/10/2024", "11/10/2024"
        )
        val desList = arrayOf(
            "sieu vaty ngo", "tai nang dang cap", "tim hieu qua da con trong nhu",
            "Dira dbay gio con ", "Eric nhac tgre song dong", "Fuka boi vi tinh",
            "vui khong hoi Gahe", "vi sa Hios trong mo"
        )
        val isComicList = arrayOf(
            true,false,true,false, true,false,true,false
        )
        val imgUrlList = arrayOf(
            R.drawable.a5, R.drawable.a6, R.drawable.a1, R.drawable.a2,
            R.drawable.a1, R.drawable.a2, R.drawable.a3, R.drawable.a4

        )
        val bgImgUrlList = arrayOf(
            R.drawable.a1, R.drawable.a2, R.drawable.a3, R.drawable.a4,
            R.drawable.a5, R.drawable.a6, R.drawable.a1, R.drawable.a2
        )
        val scoreList = arrayOf(3.5f, 4f, 5f, 1f, 4.5f, 1f, 4.5f, 2f)
        val idStoriesList = arrayOf(1,2,3,4,5,6,7,8)

        for(i in titleList.indices){
            val item = StoryDataClass(
                idStoriesList[i],
                titleList[i],
                authorList[i],
                desList[i],
                imgUrlList[i],
                bgImgUrlList[i],
                dateList[i],
                scoreList[i],
                isComicList[i]
            )
            addData(item)
        }
    }
    //-----------------------------------------------------
    fun addGenre(item : GenreDataClass){
        listOfGenre.add(item)
    }
    fun getListOfGenre(): List<GenreDataClass>{
        listOfGenre.clear()
        generateListOfGenre()
        return  listOfGenre
    }
    private fun generateListOfGenre(){
        var titleList = arrayOf(
            "Chiến đấu",
            "Cha cha cha",
            "Co don",

            "Tình cảm",
            "Hài hước",
            "Nhanh nhay",
            "kịch tính",
            "U mê",
            "Sành ăn"

        )
        var idList = arrayOf(
            11,22,33,44,55,66,77,88,99

        )
        for(i in idList.indices){
            var item = GenreDataClass(
                idList[i],titleList[i]
            )
            addGenre(item)
        }



    }
    //------------------------------
    fun getOneChapter(): ChapterDataClass{
        return ChapterDataClass(1,"Chuong 1: khong gia tri","01/02/2024")
    }
    fun addChapter(item : ChapterDataClass){
        listOfChapter.add(item)
    }
    fun getListOfChapter(): List<ChapterDataClass>{
        listOfChapter.clear()
        generateListOfChapter()
        return  listOfChapter
    }
    private fun generateListOfChapter(){

        var titleList = arrayOf(
          "Chuong 1: hoho",
            "Chuong 2: hoho",
            "Chuong 3: hohoa",
            "Chuong 4: hoho e ew werwer",
            "Chuong 5: hoho sfge",
            "Chuong 6: hohodas",

        )
        var dateCraetedList = arrayOf(
           "01/02/2024",
            "01/03/2024",
            "01/04/2024",
            "01/05/2024",
            "01/06/2024",
            "01/07/2024",

            )
        var idList = arrayOf(
           1,2,3,4,5,6

        )
        for(i in idList.indices){
            var item = ChapterDataClass(
                idList[i],titleList[i],dateCraetedList[i]
            )
            addChapter(item)
        }



    }
    //------------------------------
    fun addParagraph(item : ParagraphDataClass){
        listOfParagraph.add(item)
    }
    fun addParagraph(item: Array<ParagraphDataClass> ){
        listOfParagraph.addAll(item)
    }
    fun getOneComicParagraph(): ParagraphDataClass{
       return ParagraphDataClass(3,R.drawable.pa1, null,1,2)
    }
    fun getOneTextParagraph(context:Context): ParagraphDataClass{
        return ParagraphDataClass(1,null, getLoremIpsumLong(context),1,1,false)
    }
    fun getListOfParagraph(context: Context): List<ParagraphDataClass>{
        listOfParagraph.clear()
        generateListOfParagraph(context)
        return  listOfParagraph
    }
    private fun generateListOfParagraph(context: Context){

            var item1 = ParagraphDataClass(1,null, getLoremIpsumLong(context),1,1,false)
        var item2 = ParagraphDataClass(2,null, getLoremIpsumLong(context),2,1,false)
        var item3 = ParagraphDataClass(3,R.drawable.pa1, null,1,2)
        var item4 = ParagraphDataClass(4,R.drawable.pa2, null,2,2)
        var item5 = ParagraphDataClass(5,null, getLoremIpsumLong(context),1,3,false)
        var item6 = ParagraphDataClass(6,null, getLoremIpsumLong(context),2,3,false)
        var item7 = ParagraphDataClass(7,R.drawable.pa3, null,1,4)
        var item8 = ParagraphDataClass(8,R.drawable.pa4, null,2,4)
        var item9 = ParagraphDataClass(9,null, getLoremIpsumLong(context),1,5,false)
        var item10 = ParagraphDataClass(10,null, getLoremIpsumLong(context),2,5,false)
        var item11 = ParagraphDataClass(11,R.drawable.pa1, null,1,6)
        var item12 = ParagraphDataClass(12,R.drawable.pa2, null,2,6)


        addParagraph(arrayOf(item1,item2,item3,item4,item5,item6,item7,item8,item9,item10,item11,item12))




    }
}