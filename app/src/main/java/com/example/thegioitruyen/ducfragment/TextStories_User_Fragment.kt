package com.example.thegioitruyen.ducfragment

import android.content.Intent
import android.os.Bundle
import android.view.Gravity
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridLayout
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.thegioitruyen.R
import com.example.thegioitruyen.ducactivity.SearchActivity
import com.example.thegioitruyen.databinding.FragmentTextStoriesBinding
import com.example.thegioitruyen.ducactivity.StoryOverviewActivity
import com.example.thegioitruyen.ducadapter.Button_Adapter
import com.example.thegioitruyen.ducdataclass.GenreDataClass
import com.example.thegioitruyen.ducutils.changeShapeBackgroundColorByScore
import com.example.thegioitruyen.ducutils.dpToPx
import com.example.thegioitruyen.ducutils.toActivity
import com.example.thegioitruyen.ducviewmodel.GenreViewModel
import com.example.thegioitruyen.ducviewmodel.StoryViewModel
import kotlin.getValue

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [TextStories_User_Fragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class TextStories_User_Fragment : Fragment() {
    private lateinit var binding: FragmentTextStoriesBinding
    private lateinit var recyclerViewGenreButton: RecyclerView
    private lateinit var linearLayout: LinearLayout
    private val storyViewModel: StoryViewModel by viewModels()
    private val genreViewModel: GenreViewModel by viewModels()



    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

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
        //val view=inflater.inflate(R.layout.fragment_text_stories, container, false)
        binding= FragmentTextStoriesBinding.inflate(layoutInflater)
        val view=binding.root
//--------------------------------------

        linearLayout=view.findViewById<LinearLayout>(R.id.linearLayout_fragment_textStoryUser)

        recyclerViewGenreButton =view.findViewById<RecyclerView>(R.id.rv_buttonGenre_textStoriesUser)






        ///////////////////////
        recyclerViewGenreButton.layoutManager= GridLayoutManager(view.context,1, GridLayoutManager.HORIZONTAL,false)
        recyclerViewGenreButton.adapter= Button_Adapter(requireContext(),ArrayList( genreViewModel.genres.value),false)
        genreViewModel.genres.observe(viewLifecycleOwner, Observer {genres->
            for(i in genres )
            {
                creatGridCardViewStory(i,inflater,container,linearLayout)

            }

        })


        var searchImgBtn=view.findViewById<ImageView>(R.id.searchButton_textStoriesUser)
        var linearSearchLayout=view.findViewById<LinearLayout>(R.id.linearLayout_search_fragment_textStoryUser)

        linearSearchLayout.setOnClickListener{
            var intent = Intent(view.context, SearchActivity::class.java)
            startActivity(intent)

        }
        searchImgBtn.setOnClickListener{
            var intent = Intent(view.context, SearchActivity::class.java)
            startActivity(intent)
            linearSearchLayout.isPressed=true
        }



        // Inflate the layout for this fragment
        return view
    }
    fun creatGridCardViewStory(
        genre: GenreDataClass, inflater:LayoutInflater,container: ViewGroup?,
        linearLayoutParent: LinearLayout){
        val listCardStoriesLayout = inflater.inflate(R.layout.list_card_stories_layout,container,false)
        var gridLayout=listCardStoriesLayout.findViewById<GridLayout>(R.id.gridLayout_listCardStory)
        var txtGenre=listCardStoriesLayout.findViewById<TextView>(R.id.genre_listCardStory)

        for ( i in storyViewModel.getTextStoriesByGenre(genre)){
            var cardView =inflater.inflate(R.layout.card_story_item_layout,container,false)
            var title=cardView.findViewById<TextView>(R.id.txtTitleCardStoryItemLayout)
            var author =cardView.findViewById<TextView>(R.id.txtAuthorCardStoryItemLayout)
            var imgURL=cardView.findViewById<ImageView>(R.id.imgCardStoryItemLayout)
            var score =cardView.findViewById<TextView>(R.id.txtRankCardStoryItemLayout)
            var idStory =cardView.findViewById<TextView>(R.id.idStory_CardStoryItem)
            var constraintLayout =cardView.findViewById<ConstraintLayout>(R.id.constraintLayoutCardStoryLayout)

            title.text=i.title
            author.text=i.author
            imgURL.setImageResource(i.imgURL)

            score.text= (i.score).toString()
            idStory.text=i.idStory.toString()
           constraintLayout.changeShapeBackgroundColorByScore(i.score)
            cardView.setOnClickListener({
                //Toast.makeText(requireContext(),"ID: ${idStory.text}- ${title.text}", Toast.LENGTH_SHORT).show()
                // truyen mot dataclass den activity moi
                requireContext().toActivity(StoryOverviewActivity::class.java, R.string.key_storyInfo,i)



            })
            cardView.apply {
                layoutParams = GridLayout.LayoutParams().apply {

                    columnSpec = GridLayout.spec(GridLayout.UNDEFINED, 1f) // layout_columnWeight="1"
                    setGravity(Gravity.CENTER)
                    setMargins(0,0,0,10.dpToPx())
                }
            }
            txtGenre.text=genre.title
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
         * @return A new instance of fragment TextStoriesFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            TextStories_User_Fragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}