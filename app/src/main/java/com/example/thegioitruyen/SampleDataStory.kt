package com.example.thegioitruyen

import com.example.thegioitruyen.ducdataclass.StoryDataClass
import com.example.thegioitruyen.ducdataclass.ChapterDataClass
import com.example.thegioitruyen.ducdataclass.GenreDataClass

object SampleDataStory {
    private val dataList= mutableListOf<StoryDataClass>()
    private val listOfGenre = mutableListOf<GenreDataClass>()
    private val listOfChapter = mutableListOf<ChapterDataClass>()
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
}