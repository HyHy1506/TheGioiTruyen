package com.example.thegioitruyen.ducactivity

import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.NestedScrollView
import com.example.thegioitruyen.R
import com.example.thegioitruyen.databinding.ActivityChapterBinding
import com.example.thegioitruyen.ducutils.hideKeyboard
import com.example.thegioitruyen.ducutils.scrollToBottom

class ChapterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityChapterBinding
//    private lateinit var btnOpenCommentDialog: ImageButton
//    private lateinit var btnBackActivity: ImageButton
//    private lateinit var btnOpenCommentDialog: ImageButton
//    private lateinit var btnOpenCommentDialog: ImageButton
//    private lateinit var btnOpenCommentDialog: ImageButton

    private var isTopFrameVisible = true
    private var isBottomFrameVisible = true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityChapterBinding.inflate(layoutInflater)
        val view = binding.root
        enableEdgeToEdge()
        setContentView(view)

        var scrollView=binding.scrollParagraphChapter
        var frameTop=binding.frameTopChapter
        var frameBottom=binding.frameBottomChapter

        setAnimationScollView(binding)
        setConfigCommentDialog(binding)
        setConfigButtonChapter(binding)





    }

    private fun setConfigButtonChapter(binding: ActivityChapterBinding) {
        var btnOpenCommentDialog=binding.btnOpenCommentDialogChapter
        var btnBackActivity=binding.btnBackChapter
        btnBackActivity.setOnClickListener{
            finish()
        }
        btnOpenCommentDialog.setOnClickListener{
            binding.frameContainerCommentDialogChapter.visibility= View.VISIBLE
            binding.scrollViewMainCommentDialogChapter.scrollToBottom()
        }

    }

    private fun setConfigCommentDialog(binding: ActivityChapterBinding) {
        binding.frameContainerCommentDialogChapter.visibility= View.GONE
        var viewBackground=binding.viewBackgroundCommentDialogChapter
        var btnBack=binding.btnBackCommentDialogChaper

        btnBack.setOnClickListener{
            binding.frameContainerCommentDialogChapter.visibility= View.GONE
            btnBack.hideKeyboard(this)
        }
        viewBackground.setOnClickListener{
            viewBackground.hideKeyboard(this)
            binding.frameContainerCommentDialogChapter.visibility= View.GONE
        }

    }

    private fun setAnimationScollView(binding: ActivityChapterBinding) {
        var scrollView=binding.scrollParagraphChapter
        var frameTop=binding.frameTopChapter
        var frameBottom=binding.frameBottomChapter
        scrollView.setOnScrollChangeListener(NestedScrollView.OnScrollChangeListener{_,_,scrollY,_,oldScrollY ->

            if(scrollY>oldScrollY){
                if(isTopFrameVisible)
                {
                    frameTop.startAnimation(AnimationUtils.loadAnimation(this, R.anim.slide_up))
                    frameTop.visibility= View.GONE
                    isTopFrameVisible=false
                }
                if(isBottomFrameVisible)
                {
                    frameBottom.startAnimation(AnimationUtils.loadAnimation(this, R.anim.slide_down))
                    frameBottom.visibility= View.GONE
                    isBottomFrameVisible=false
                }

            }else if (scrollY < oldScrollY) {
                // Cuộn lên, hiện các Frame
                if (!isTopFrameVisible) {
                    //frameTop.startAnimation(AnimationUtils.loadAnimation(this, R.anim.slide_down))
                    frameTop.visibility = View.VISIBLE
                    isTopFrameVisible = true
                }
                if (!isBottomFrameVisible) {
                    //frameBottom.startAnimation(AnimationUtils.loadAnimation(this, R.anim.slide_up))
                    frameBottom.visibility = View.VISIBLE
                    isBottomFrameVisible = true
                }}
        })
    }

}