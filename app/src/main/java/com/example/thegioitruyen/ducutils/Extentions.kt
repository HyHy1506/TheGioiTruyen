package com.example.thegioitruyen.ducutils


import android.content.res.Resources
import android.view.View
import android.widget.ScrollView
import android.content.Context
import android.graphics.PorterDuff
import android.os.Build
import android.view.inputmethod.InputMethodManager
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

