package com.example.thegioitruyen.ducutils


import android.app.Activity
import android.content.res.Resources
import android.view.View
import android.widget.ScrollView
import android.content.Context
import android.content.Intent
import android.graphics.PorterDuff
import android.os.Build
import android.os.Bundle
import android.os.Parcelable
import android.view.Gravity
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.GridLayout
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.thegioitruyen.R
import com.example.thegioitruyen.databinding.CardStoryItemLayoutBinding
import com.example.thegioitruyen.databinding.ListCardStoriesLayoutBinding
import com.example.thegioitruyen.ducactivity.StoriesByGenreActivity
import com.example.thegioitruyen.ducactivity.StoryOverviewActivity
import com.example.thegioitruyen.ducdataclass.GenreDataClass
import com.example.thegioitruyen.ducdataclass.ParagraphDataClass
import com.example.thegioitruyen.ducdataclass.StoryDataClass
import com.example.thegioitruyen.ducutils.toActivity
import java.io.Serializable
//-------------------------------------


fun getDataNotFound(context: Context): String {
    return context.getString(R.string.dataNotFound)
}
fun getLoremIpsum(context: Context): String = context.getString(R.string.loremIpsum)
fun getLoremIpsumLong(context: Context): String = context.getString(R.string.loremIpsumLong)
fun getKeyStoryInfo(context: Context): String = context.getString(R.string.key_storyInfo)
fun getKeyStoriesByGenre(context: Context): String = context.getString(R.string.key_storiesByGenre)
fun getKeyIsComic(context: Context): String = context.getString(R.string.key_isComic)
fun getKeyGenreInfo(context: Context): String = context.getString(R.string.key_genreInfo)
fun getKeyChapterInfo(context: Context): String = context.getString(R.string.key_chapterInfo)
fun getKeyPreviousChapterInfo(context: Context): String = context.getString(R.string.key_previousChapterInfo)
fun getKeyNextChapterInfo(context: Context): String = context.getString(R.string.key_nextChapterInfo)
fun getKeyMainChapterInfo(context: Context): String = context.getString(R.string.key_mainChapterInfo)
fun getKeyResultSearchInfo(context: Context): String = context.getString(R.string.key_resultSearchInfo)
fun getKeyTextQuery(context: Context): String = context.getString(R.string.key_textQuery)
fun getImageAvatar(context: Context):Int =R.drawable.cat
fun getLoremIpsum(): String{
    return "lorem Ipsum"
}
fun getLoremIpsumLong(): String{
    return "Lorem ipsum odor amet, consectetuer adipiscing elit. Ullamcorper scelerisque vivamus leo pharetra inceptos litora vel cubilia himenaeos? Mi cras velit a dapibus rutrum nec imperdiet venenatis. Egestas accumsan inceptos aenean inceptos fringilla tortor facilisi et. Nisi ultrices ornare ex id pellentesque tristique magna ullamcorper. Feugiat massa nisi vivamus morbi platea pellentesque vehicula tellus. Dolor parturient fermentum nascetur, volutpat pretium fringilla."
}
fun getTextDataNotFound(context: Context): String{
    return context.resources.getString(R.string.dataNotFound)
}

//--------------------------------------




fun Int.dpToPx(): Int {
    return (this * Resources.getSystem().displayMetrics.density).toInt()
}
fun ScrollView.scrollToBottom() {
    post {
        fullScroll(View.FOCUS_DOWN)
    }
}

fun View.hideKeyboard(context: Context) {
    val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.hideSoftInputFromWindow(windowToken, 0)
}
fun View.changeShapeBackgroundColorByScore(score:Float){
    if(score>=4f){
        this.setBackgroundResource(R.drawable.shape_green_story_item_layout)

    }else if(score>=2.5f&& score<4f ){
        this.setBackgroundResource(R.drawable.shape_yellow_card_story_item_layout)

    }else{
        this.setBackgroundResource(R.drawable.shape_red_card_story_item_layout)

    }
}
fun View.changeBackgroundTintColorByScore(score:Float){
    var drawable = background
    val color = when{
        score>=4f -> R.color.green2
        score>=2.5f -> R.color.duc_yellow
        else -> R.color.duc_red
    }
    val colorFilter=context.getColor(color)

    drawable.setColorFilter(colorFilter, PorterDuff.Mode.SRC_ATOP)
}
fun Context.toActivity(activityClass: Class<out Activity>, key: Int, value: Parcelable?){
    var intent= Intent(this, activityClass)
    intent.putExtra(this.resources.getString(key),value)
    this.startActivity(intent)
}
fun Context.toActivity(activityClass: Class<out Activity>, key: String, value: Parcelable?){
    var intent= Intent(this, activityClass)
    intent.putExtra(key,value)
    this.startActivity(intent)
}
fun Context.toActivity(activityClass: Class<out Activity>, key: Int, value: Serializable?){
    var intent= Intent(this, activityClass)
    intent.putExtra(this.resources.getString(key),value)
    this.startActivity(intent)
}
fun Context.toActivity(activityClass: Class<out Activity>, key: Int, value: Bundle?){
    var intent= Intent(this, activityClass)
    intent.putExtra(this.resources.getString(key),value)
    this.startActivity(intent)
}
fun Context.toActivity(activityClass: Class<out Activity>, key: String, value: Serializable?){
    var intent= Intent(this, activityClass)
    intent.putExtra(key,value)
    this.startActivity(intent)
}
fun Context.toActivity(activityClass: Class<out Activity>, key: String, value: Bundle?){
    var intent= Intent(this, activityClass)
    intent.putExtra(key,value)
    this.startActivity(intent)
}
fun showTestToast(context: Context){
    Toast.makeText(context,"oke", Toast.LENGTH_SHORT).show()
}

fun showTestToast(context: Context,text:String){
    Toast.makeText(context,text, Toast.LENGTH_SHORT).show()
}
fun showTestToastLong(context: Context,text:String){
    Toast.makeText(context,text, Toast.LENGTH_LONG).show()
}
fun getKey_mainChapter(context: Context):String{
    return context.resources.getString(R.string.key_mainChapterInfo)
}
fun getKey_nextChapter(context: Context):String{
    return context.resources.getString(R.string.key_nextChapterInfo)
}
fun getKey_previousChapter(context: Context):String{
    return context.resources.getString(R.string.key_previousChapterInfo)
}
fun getKey_chapterInfo(context: Context):String{
    return context.resources.getString(R.string.key_chapterInfo)
}
fun createGridCardViewStory(
    context: Context,
     inflater:LayoutInflater,
    viewGroup: ViewGroup ,genre: GenreDataClass,
    dataList: List<StoryDataClass> ){
    var blistCardStoriesLayout= ListCardStoriesLayoutBinding.inflate(inflater)
    val listCardStoriesLayout = blistCardStoriesLayout.root
    var gridLayout=blistCardStoriesLayout.gridLayoutListCardStory
    var txtGenre=blistCardStoriesLayout.genreListCardStory
//        val listCardStoriesLayout = inflater.inflate(R.layout.list_card_stories_layout,container,false)
//        var gridLayout=listCardStoriesLayout.findViewById<GridLayout>(R.id.gridLayout_listCardStory)
//        var txtGenre=listCardStoriesLayout.findViewById<TextView>(R.id.genre_listCardStory)
    for(i in dataList){
        var bCardView= CardStoryItemLayoutBinding.inflate(inflater)
        var cardView =bCardView.root
        var title=bCardView.txtTitleCardStoryItemLayout
        var author =bCardView.txtAuthorCardStoryItemLayout
        var imgURL=bCardView.imgCardStoryItemLayout
        var score =bCardView.txtRankCardStoryItemLayout
        var idStory =bCardView.idStoryCardStoryItem
        var constraintLayout =bCardView.constraintLayoutCardStoryLayout
        title.text=i.title
        author.text=i.author
        imgURL.setImageResource(i.imgURL)

        score.text= (i.score).toString()
        idStory.text=i.idStory.toString()
        constraintLayout.changeShapeBackgroundColorByScore(i.score)
        cardView.setOnClickListener({
            // truyen mot dataclass den activity moi
            context.toActivity(StoryOverviewActivity::class.java, context.getString(R.string.key_storyInfo),i)

            //   .toActivity(StoryOverviewActivity::class.java, R.string.key_storyInfo,i)
        })
        cardView.apply {
            layoutParams = GridLayout.LayoutParams().apply {
                columnSpec = GridLayout.spec(GridLayout.UNDEFINED, 1f) // layout_columnWeight="1"
                setGravity(Gravity.CENTER)
                setMargins(0,0,0, 10.dpToPx() )

            }
        }

        txtGenre.text=genre.title
        gridLayout.addView(cardView)

    }


    viewGroup.addView(listCardStoriesLayout)
    //return listCardStoriesLayout
}
fun Context.toActivityStoriesByGenre(isComic: Boolean,genre: GenreDataClass){
    var keyIsComic = getKeyIsComic(this)
    var keyGenreInfo = getKeyGenreInfo(this)
    var bundle = Bundle()
    bundle.putBoolean(keyIsComic, isComic)
    bundle.putParcelable(keyGenreInfo, genre)
        toActivity(StoriesByGenreActivity::class.java, getKeyStoriesByGenre(this), bundle)
}
fun getExampleGenre(context: Context): GenreDataClass{
    var title= context.getString(R.string.dataNotFound)
    return GenreDataClass(1, title)
}
fun getExampleComicParagraph(context: Context): ParagraphDataClass{
    return ParagraphDataClass(
        1
        ,R.drawable.pa1
        , context.getString(R.string.loremIpsum),
        1,1,true)
}
fun getExampleTextParagraph(context: Context): ParagraphDataClass{
    return ParagraphDataClass(
        1
        ,R.drawable.pa1
        , context.getString(R.string.loremIpsum),
        1,1,false)
}
fun getExampleComicStory(context: Context): StoryDataClass{
    return StoryDataClass(1,
       context.getString(R.string.dataNotFound),
       context.getString(R.string.dataNotFound),
        context.getString(R.string.loremIpsum),
        R.drawable.a1,
        R.drawable.a2,
        context.getString(R.string.loremIpsum),
        4f,
        true
        )
}
fun getExampleTextStory(context: Context): StoryDataClass{
    return StoryDataClass(1,
        context.getString(R.string.dataNotFound),
       context.getString(R.string.dataNotFound),
        context.getString(R.string.loremIpsum),
        R.drawable.a1,
        R.drawable.a2,
     context.getString(R.string.loremIpsum),
        4f,
        false
    )
}