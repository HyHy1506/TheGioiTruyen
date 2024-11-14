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
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.thegioitruyen.R
import com.example.thegioitruyen.ducactivity.StoryOverviewActivity
import java.io.Serializable
//-------------------------------------
var loremIpsum="Lorem ipsum odor amet, consectetuer adipiscing elit. Acurae conubia habitasse feugiat urna vestibulum dis. Faucibus ultricies leo fusce accumsan suscipit sapien penatibus. Nulla per ad curae erat dolor; eu nisi? Iaculis turpis efficitur ad nascetur quisque commodo justo pharetra. Finibus ultrices gravida condimentum laoreet magna eget. Phasellus inceptos fames nisl nibh nisl rhoncus. Sagittis conubia ornare leo fermentum dapibus mus. Dictum facilisis faucibus curabitur purus nec proin. Torquent dui fringilla class pretium odio tellus at! Turpis ornare gravida metus amet, molestie augue eget. Non ornare vehicula potenti mollis gravida duis nostra. Aliquet tortor semper consectetur enim faucibus tempus, turpis arcu penatibus."

//--------------------------------------
fun getLoremIpsum(context: Context): String{
    return context.resources.getString(R.string.loremIpsum)
}
fun getTextDataNotFound(context: Context): String{
    return context.resources.getString(R.string.dataNotFound)
}
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