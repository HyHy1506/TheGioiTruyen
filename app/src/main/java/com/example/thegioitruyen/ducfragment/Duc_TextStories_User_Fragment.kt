package com.example.thegioitruyen.ducfragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.thegioitruyen.ducactivity.DucSearchActivity
import com.example.thegioitruyen.databinding.FragmentDucTextStoriesBinding
import com.example.thegioitruyen.ducadapter.Duc_Button_Adapter
import com.example.thegioitruyen.ducutils.createGridCardViewStory
import com.example.thegioitruyen.ducutils.getKeyIsComic
import com.example.thegioitruyen.ducviewmodel.DucGenreViewModel
import com.example.thegioitruyen.ducviewmodel.DucStoryViewModel
import com.example.thegioitruyen.ducviewmodelfactory.DucGenreViewModelFactory
import com.example.thegioitruyen.ducviewmodelfactory.DucStoryViewModelFactory
import kotlin.getValue

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Duc_TextStories_User_Fragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class Duc_TextStories_User_Fragment : Fragment() {
    private lateinit var binding: FragmentDucTextStoriesBinding
    private lateinit var recyclerViewGenreButton: RecyclerView
    private lateinit var linearLayout: LinearLayout
    private val ducStoryViewModel: DucStoryViewModel by viewModels{
        DucStoryViewModelFactory(requireContext())
    }
    private val ducGenreViewModel: DucGenreViewModel by viewModels{
        DucGenreViewModelFactory(requireContext())
    }
    private var isComic=false


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
        binding= FragmentDucTextStoriesBinding.inflate(layoutInflater)
        val view=binding.root
//--------------------------------------

        linearLayout=binding.linearLayoutFragmentTextStoryUser

        recyclerViewGenreButton =binding.rvButtonGenreTextStoriesUser






        ///////////////////////
        recyclerViewGenreButton.layoutManager= GridLayoutManager(view.context,
            1,
            GridLayoutManager.HORIZONTAL,false)
        recyclerViewGenreButton.adapter= Duc_Button_Adapter(
            requireContext(),ArrayList( ducGenreViewModel.getAllGenres()),
            isComic)

            for(i in ducGenreViewModel.getAllGenres() )
            {
                createGridCardViewStory(requireContext()
                    ,inflater
                    ,linearLayout
                    ,i,
                    ducStoryViewModel.getTextStoriesByGenre(i))

                //creatGridCardViewStory(i,inflater,container,linearLayout)

            }




        var searchImgBtn=binding.searchButtonTextStoriesUser


        searchImgBtn.setOnClickListener{
            toSearchActivity()
        }



        // Inflate the layout for this fragment
        return view
    }
    fun toSearchActivity(){
        var intent = Intent(context, DucSearchActivity::class.java)
        intent.putExtra(getKeyIsComic(requireContext()),isComic)
        startActivity(intent)
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
            Duc_TextStories_User_Fragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}