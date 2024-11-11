package com.example.thegioitruyen.ducutils


import android.app.Activity
import android.content.res.Resources
import android.util.TypedValue
import android.view.View
import android.widget.Button
import android.widget.ScrollView
import android.content.Context
import android.view.inputmethod.InputMethodManager
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import com.example.thegioitruyen.R

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
fun View.changeBackgroundColorByScore(score:Float){
    if(score>=4f){
        this.setBackgroundResource(R.drawable.shape_green_story_item_layout)

    }else if(score>=2.5f&& score<4f ){
        this.setBackgroundResource(R.drawable.shape_yellow_card_story_item_layout)

    }else{
        this.setBackgroundResource(R.drawable.shape_red_card_story_item_layout)

    }
}
