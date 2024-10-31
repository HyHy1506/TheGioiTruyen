package com.example.thegioitruyen.ducfragment


import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.GridLayout
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout

import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.thegioitruyen.R
import com.example.thegioitruyen.SampleDataStory
import com.example.thegioitruyen.SearchActivity
import com.example.thegioitruyen.StoryOverviewActivity
import com.example.thegioitruyen.ducadapter.Button_Adapter
import com.example.thegioitruyen.ducdataclass.CardStoryItem_DataClass
import com.example.thegioitruyen.ducdataclass.GenreDataClass

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ComicStories_User_Fragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ComicStories_User_Fragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var recyclerViewGenreButton: RecyclerView
    private lateinit var linearLayout: LinearLayout



    private lateinit var dataList: ArrayList<CardStoryItem_DataClass>
    private lateinit var genreList: ArrayList<GenreDataClass>



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }

  }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =inflater.inflate(R.layout.fragment_comic_stories_user, container, false)
         linearLayout=view.findViewById<LinearLayout>(R.id.linearLayout_fragment_comicStoryUser)

        recyclerViewGenreButton =view.findViewById<RecyclerView>(R.id.rv_buttonGenre_ComicStoriesUser)
        SampleDataStory.generateData()
        SampleDataStory.generateListOfGenre()
        SampleDataStory.generateListOfChapter()

        dataList = ArrayList(SampleDataStory.getDataList())
        genreList = ArrayList(SampleDataStory.getListOfGenre())




        ///////////////////////
        recyclerViewGenreButton.layoutManager= GridLayoutManager(view.context,1, GridLayoutManager.HORIZONTAL,false)
        recyclerViewGenreButton.adapter= Button_Adapter(genreList)

        for(i in genreList.indices)
        {
            creatGridCardViewStory(genreList[i].title,inflater,container,linearLayout)

        }

        var searchImgBtn=view.findViewById<ImageView>(R.id.searchButton_ComicStoriesUser)
        var linearSearchLayout=view.findViewById<LinearLayout>(R.id.linearLayout_search_fragment_comicStoryUser)

        linearSearchLayout.setOnClickListener{
            var intent = Intent(view.context, SearchActivity::class.java)
            startActivity(intent)

        }
        searchImgBtn.setOnClickListener{
            var intent = Intent(view.context, SearchActivity::class.java)
            startActivity(intent)
            linearSearchLayout.isPressed=true
        }
        ///////////////////////

//       ---------------------------------------------------------------------------------
        // Inflate the layout for this fragment
        return view
    }


    fun creatGridCardViewStory(
        genre: String, inflater:LayoutInflater,container: ViewGroup?,
        linearLayoutParent: LinearLayout){
        val listCardStoriesLayout = inflater.inflate(R.layout.list_card_stories_layout,container,false)
        var gridLayout=listCardStoriesLayout.findViewById<GridLayout>(R.id.gridLayout_listCardStory)
        var txtGenre=listCardStoriesLayout.findViewById<TextView>(R.id.genre_listCardStory)

        for ( i in dataList.indices){
            if(dataList[i].isComic==false)continue
            var cardView =inflater.inflate(R.layout.card_story_item_layout,container,false)
            var title=cardView.findViewById<TextView>(R.id.txtTitleCardStoryItemLayout)
            var author =cardView.findViewById<TextView>(R.id.txtAuthorCardStoryItemLayout)
            var imgURL=cardView.findViewById<ImageView>(R.id.imgCardStoryItemLayout)
            var score =cardView.findViewById<TextView>(R.id.txtRankCardStoryItemLayout)
            var idStory =cardView.findViewById<TextView>(R.id.idStory_CardStoryItem)
            var constraintLayout =cardView.findViewById<ConstraintLayout>(R.id.constraintLayoutCardStoryLayout)

            title.text=dataList[i].title
            author.text=dataList[i].author
            imgURL.setImageResource(dataList[i].imgURL)

            score.text= (dataList[i].score).toString()
            idStory.text=dataList[i].idStory.toString()
            if(dataList[i].score>=4f){
                constraintLayout.setBackgroundResource(R.drawable.shape_green_story_item_layout)

            }else if(dataList[i].score>=2.5f&&dataList[i].score<4f ){
                constraintLayout.setBackgroundResource(R.drawable.shape_yellow_card_story_item_layout)

            }else{
                constraintLayout.setBackgroundResource(R.drawable.shape_red_card_story_item_layout)

            }
            cardView.setOnClickListener({
//                Toast.makeText(requireContext(),"ID: ${idStory.text}- ${title.text}", Toast.LENGTH_SHORT).show()
            var intent= Intent(context, StoryOverviewActivity::class.java)
            startActivity(intent)
            })
            cardView.apply {
                layoutParams = GridLayout.LayoutParams().apply {

                    columnSpec = GridLayout.spec(GridLayout.UNDEFINED, 1f) // layout_columnWeight="1"
                    setGravity(Gravity.CENTER)
                    setMargins(16, 16, 16, 16)
                }
            }
            txtGenre.text=genre
            gridLayout.addView(cardView)

        }

        linearLayoutParent.addView(listCardStoriesLayout)
        //return listCardStoriesLayout
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ComicStoriesUserFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ComicStories_User_Fragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}