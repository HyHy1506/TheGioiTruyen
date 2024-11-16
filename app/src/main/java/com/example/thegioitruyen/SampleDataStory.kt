package com.example.thegioitruyen

import android.content.Context
import com.example.thegioitruyen.ducdataclass.StoryDataClass
import com.example.thegioitruyen.ducdataclass.ChapterDataClass
import com.example.thegioitruyen.ducdataclass.CommentDataClass
import com.example.thegioitruyen.ducdataclass.GenreDataClass
import com.example.thegioitruyen.ducdataclass.ParagraphDataClass
import com.example.thegioitruyen.ducutils.getLoremIpsum
import com.example.thegioitruyen.ducutils.getLoremIpsumLong
import com.example.thegioitruyen.ducutils.showTestToast
import com.example.thegioitruyen.ducviewmodel.ParagraphViewModel

object SampleDataStory {
    private val dataList= mutableListOf<StoryDataClass>()
    private val listOfGenre = mutableListOf<GenreDataClass>()
    private val listOfChapter = mutableListOf<ChapterDataClass>()
    private val listOfParagraph = mutableListOf<ParagraphDataClass>()
    private val listOfComment = mutableListOf<CommentDataClass>()
    private var sumIdComment:Int=0
    var idUser:Int get()=4
        private set(value) {}
    var date: String get() ="11/11/2004"
        private set(value) {}
    //-----------------------------------------------------
    init {
        generateData()
        generateListOfGenre()
        generateListOfComment()
        generateListOfParagraph()
        generateListOfChapter()
    }
    fun getOneStoryByID(context: Context,idStory:Int): StoryDataClass{
        return getDataList(context).filter { it.idStory==idStory }.first()
    }
    fun addData(data : StoryDataClass){
        dataList.add(data)
    }
    fun getDataList(context: Context): List<StoryDataClass>{
//        dataList.clear()
//        generateData()
        return dataList
    }
    private fun generateData(){
        val titleList = arrayOf(
            "Cau chuyen", "Xua kia", "Muon Thua Khac Ghi Nao", "HUNTER×HUNTER",
            "Khu bảo tồn khủng long", "Bất tử và Bất hạnh", "Blue Box", "Tiệm Đồ Ngọt"
        )
        val authorList = arrayOf(
            "Tran van A", "To B", "Togashi Yoshihiro", "Dira", "Eric", "Fuka", "Gahe", "Hios"
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
            true,true,true,true,false,false,false,false
        )
        val imgUrlList = arrayOf(
            R.drawable.a1, R.drawable.a2, R.drawable.a3, R.drawable.a4,
            R.drawable.a5, R.drawable.a6, R.drawable.a7, R.drawable.a8


        )
        val bgImgUrlList = arrayOf(
            R.drawable.a1, R.drawable.a2, R.drawable.a3, R.drawable.a4,
            R.drawable.a5, R.drawable.a6, R.drawable.a7, R.drawable.a8
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
    fun getOneGenreByID(context: Context,idGenre:Int): GenreDataClass{
        return getListOfGenre(context).filter { it.idGenre==idGenre }.first()
    }
    fun addGenre(item : GenreDataClass){
        listOfGenre.add(item)
    }
    fun getListOfGenre(context: Context): List<GenreDataClass>{
//        listOfGenre.clear()
//        generateListOfGenre()
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
            1,2,3,4,5,6,7,8,9

        )
        for(i in idList.indices){
            var item = GenreDataClass(
                idList[i],titleList[i]
            )
            addGenre(item)
        }



    }
    //------------------------------
    fun getOneChapterByID(context: Context,idChapter:Int): ChapterDataClass{
        return getListOfChapter(context).filter { it.idChapter==idChapter }.first()
    }
    fun getOneChapter(): ChapterDataClass{
        return ChapterDataClass(1,1,"Chuong 1: khong gia tri","01/02/2024")
    }
    fun addChapter(item : ChapterDataClass){
        listOfChapter.add(item)
    }
    fun getListOfChapter(context: Context): List<ChapterDataClass>{
//        listOfChapter.clear()
//        generateListOfChapter()
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
        var idChapter:Int=1
        for(story in dataList)
        {
            for(i in idList.indices){
                var item = ChapterDataClass(
                    idChapter,story.idStory,titleList[i]+" ${story.idStory}",dateCraetedList[i]
                )
                idChapter++
                addChapter(item)
            }
        }




    }
    //------------------------------
    fun getOneParagraphByID(context: Context,idParagraph:Int): ParagraphDataClass{
        return getListOfParagraph(context).filter { it.idParagraph==idParagraph }.first()
    }
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
//        listOfParagraph.clear()
//        generateListOfParagraph()
        return  listOfParagraph
    }
    private fun generateListOfParagraph(){
        var idParagraph:Int=1
        //so chapter hien tai cua truyen comic
        for(i in 1..24){
            var item1 = ParagraphDataClass(idParagraph,R.drawable.pa1, null,1,i)
            idParagraph++
            var item2 = ParagraphDataClass(idParagraph,R.drawable.pa2, null,2,i)
            idParagraph++
            var item3 = ParagraphDataClass(idParagraph,R.drawable.pa3, null,3,i)
            idParagraph++
            var item4 = ParagraphDataClass(idParagraph,R.drawable.pa4, null,4,i)
            idParagraph++
            addParagraph(arrayOf(item1,item2,item3,item4))

        }
        for(i in 25..48){
            var item1 = ParagraphDataClass(idParagraph,null, getLoremIpsumLong(),1,i,false)
            idParagraph++
            var item2 = ParagraphDataClass(idParagraph,null, getLoremIpsumLong(),1,i,false)
            idParagraph++
            var item3 = ParagraphDataClass(idParagraph,null, getLoremIpsumLong(),1,i,false)
            idParagraph++
            var item4 = ParagraphDataClass(idParagraph,null, getLoremIpsumLong(),1,i,false)
            idParagraph++
            addParagraph(arrayOf(item1,item2,item3,item4))
        }
//        var item1 = ParagraphDataClass(1,null, getLoremIpsumLong(),1,1,false)
//        var item2 = ParagraphDataClass(2,null, getLoremIpsumLong(),2,1,false)
//        var item3 = ParagraphDataClass(3,R.drawable.pa1, null,1,2)
//        var item4 = ParagraphDataClass(4,R.drawable.pa2, null,2,2)
//        var item5 = ParagraphDataClass(5,null, getLoremIpsumLong(),1,3,false)
//        var item6 = ParagraphDataClass(6,null, getLoremIpsumLong(),2,3,false)
//        var item7 = ParagraphDataClass(7,R.drawable.pa3, null,1,4)
//        var item8 = ParagraphDataClass(8,R.drawable.pa4, null,2,4)
//        var item9 = ParagraphDataClass(9,null, getLoremIpsumLong(),1,5,false)
//        var item10 = ParagraphDataClass(10,null, getLoremIpsumLong(),2,5,false)
//        var item11 = ParagraphDataClass(11,R.drawable.pa1, null,1,6)
//        var item12 = ParagraphDataClass(12,R.drawable.pa2, null,2,6)
//
//
//        addParagraph(arrayOf(item1,item2,item3,item4,item5,item6,item7,item8,item9,item10,item11,item12))




    }
    //---------------------------------------------------
     fun addComment(item: CommentDataClass ){
        listOfComment.add(item)
    }
    fun addUserComment(idStory:Int,content:String,date:String){

        listOfComment.add(CommentDataClass(getNextIdComment(),idStory,idUser,content,date))
    }

    fun getListOfComment(context: Context): List<CommentDataClass>{
//        listOfComment.clear()
//        generateListOfComment()
        return  listOfComment
    }
    private fun generateListOfComment(){

        for(story in dataList)
        {
            for(i in 1..3){
                var item = CommentDataClass(getNextIdComment() ,story.idStory,i, getLoremIpsum(),"11/11/2004")

                addComment(item)
            }
            addComment(CommentDataClass(getNextIdComment(),story.idStory,idUser,getLoremIpsumLong(),date))


            addComment(CommentDataClass(getNextIdComment(),story.idStory,idUser,getLoremIpsum(),date))


            for (i in 6..8) {
                var item = CommentDataClass(getNextIdComment(),story.idStory, i, getLoremIpsumLong(), "11/11/2004")
                addComment(item)
            }
        }
    }
    private fun getNextIdComment():Int{
        sumIdComment=sumIdComment+1
        return sumIdComment
    }
}