package com.example.thegioitruyen

import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.widget.NestedScrollView
import com.example.thegioitruyen.databinding.ActivityChapterBinding

class ChapterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityChapterBinding
    private var isTopFrameVisible = true
    private var isBottomFrameVisible = true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityChapterBinding.inflate(layoutInflater)
        val view = binding.root
        enableEdgeToEdge()
        var frameTop=binding.frameTopChapter
        var frameBottom=binding.frameBottomChapter
        var scrollView=binding.scrollParagraphChapter
        scrollView.setOnScrollChangeListener(NestedScrollView.OnScrollChangeListener{_,_,scrollY,_,oldScrollY ->

            if(scrollY>oldScrollY){
                if(isTopFrameVisible)
                {
                    frameTop.startAnimation(AnimationUtils.loadAnimation(this,R.anim.slide_up))
                    frameTop.visibility= View.GONE
                    isTopFrameVisible=false
                }
                if(isBottomFrameVisible)
                {
                    frameBottom.startAnimation(AnimationUtils.loadAnimation(this,R.anim.slide_down))
                    frameBottom.visibility= View.GONE
                    isBottomFrameVisible=false
                }

            }else if (scrollY < oldScrollY) {
                // Cuộn lên, hiện các Frame
                if (!isTopFrameVisible) {
                    frameTop.startAnimation(AnimationUtils.loadAnimation(this, R.anim.slide_down))
                    frameTop.visibility = View.VISIBLE
                    isTopFrameVisible = true
                }
                if (!isBottomFrameVisible) {
                    frameBottom.startAnimation(AnimationUtils.loadAnimation(this, R.anim.slide_up))
                    frameBottom.visibility = View.VISIBLE
                    isBottomFrameVisible = true
                }}
        })






        setContentView(view)

    }
}