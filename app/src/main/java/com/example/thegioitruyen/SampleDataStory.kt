package com.example.thegioitruyen

import com.example.thegioitruyen.ducdataclass.CardStoryItem_DataClass
import com.example.thegioitruyen.ducdataclass.GenreDataClass

object SampleDataStory {
    private val dataList= mutableListOf<CardStoryItem_DataClass>()
    private val listOfgenre = mutableListOf<GenreDataClass>()
    fun addData(data : CardStoryItem_DataClass){
        dataList.add(data)
    }
    fun getDataList(): List<CardStoryItem_DataClass>{
        return dataList
    }
    fun generateData(){
        val titleList = arrayOf(
            "Cau chuyen", "Xua kia", "Muon Thua Khac Ghi Nao", "Ai oi3",
            "Ai oi1", "Ai oi3", "Ai oi1", "Ai oi2"
        )
        val authorList = arrayOf(
            "Tran van A", "To B", "Luong C", "Dira", "Eric", "Fuka", "Gahe", "Hios"
        )
        val isComicList = arrayOf(
            true,false,true,false, true,false,true,false
        )
        val imgUrlList = arrayOf(
            R.drawable.a1, R.drawable.a2, R.drawable.a3, R.drawable.a4,
            R.drawable.a5, R.drawable.a6, R.drawable.a1, R.drawable.a2
        )
        val scoreList = arrayOf(3.5f, 4f, 5f, 1f, 4.5f, 1f, 4.5f, 2f)
        val idStoriesList = arrayOf(1,2,3,4,5,6,7,8)

        for(i in titleList.indices){
            val item = CardStoryItem_DataClass(
                idStoriesList[i],
                titleList[i],
                authorList[i],
                isComicList[i],
                imgUrlList[i],
                scoreList[i]
            )
            addData(item)
        }
    }
    fun addGenre(item : GenreDataClass){
        listOfgenre.add(item)
    }
    fun getListOfGenre(): List<GenreDataClass>{
        return  listOfgenre
    }
    fun generateListOfGenre(){
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
}