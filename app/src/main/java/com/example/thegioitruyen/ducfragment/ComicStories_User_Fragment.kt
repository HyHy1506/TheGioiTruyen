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
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.thegioitruyen.R
import com.example.thegioitruyen.databinding.CardStoryItemLayoutBinding
import com.example.thegioitruyen.databinding.FragmentComicStoriesUserBinding
import com.example.thegioitruyen.databinding.ListCardStoriesLayoutBinding
import com.example.thegioitruyen.ducactivity.SearchActivity
import com.example.thegioitruyen.ducactivity.StoryOverviewActivity
import com.example.thegioitruyen.ducadapter.Button_Adapter
import com.example.thegioitruyen.ducdataclass.GenreDataClass
import com.example.thegioitruyen.ducutils.changeShapeBackgroundColorByScore
import com.example.thegioitruyen.ducutils.createGridCardViewStory
import com.example.thegioitruyen.ducutils.dpToPx
import com.example.thegioitruyen.ducutils.getKeyIsComic
import com.example.thegioitruyen.ducutils.toActivity
import com.example.thegioitruyen.ducviewmodel.GenreViewModel
import com.example.thegioitruyen.ducviewmodel.StoryViewModel
import com.example.thegioitruyen.ducviewmodelfactory.GenreViewModelFactory
import com.example.thegioitruyen.ducviewmodelfactory.StoryViewModelFactory

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
    private lateinit var binding: FragmentComicStoriesUserBinding
    private lateinit var recyclerViewGenreButton: RecyclerView
    private lateinit var linearLayout: LinearLayout
    private var isComic = true


    private val storyViewModel: StoryViewModel by viewModels {
        StoryViewModelFactory(requireContext())
    }
    val genreViewModel: GenreViewModel by viewModels {
        GenreViewModelFactory(requireContext())
    }

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

        binding = FragmentComicStoriesUserBinding.inflate(layoutInflater)
        val view = binding.root
        linearLayout = binding.linearLayoutFragmentComicStoryUser
        recyclerViewGenreButton = binding.rvButtonGenreComicStoriesUser

        ///////////////////////
        recyclerViewGenreButton.layoutManager = GridLayoutManager(
            view.context, 1, GridLayoutManager.HORIZONTAL, false
        )
        recyclerViewGenreButton.adapter = Button_Adapter(
            //requireContext(), ArrayList(genreViewModel.genres.value), isComic
            requireContext(), ArrayList(genreViewModel.getAllGenres()), isComic
        )

        var searchImgBtn = binding.searchButtonComicStoriesUser

        searchImgBtn.setOnClickListener {
            toSearchActivity()
        }


        for (genre in genreViewModel.getAllGenres()) {

            createGridCardViewStory(
                requireContext(),
                inflater,
                linearLayout,
                genre,
                storyViewModel.getComicStoriesByGenre(genre)
            )
        }
//        genreViewModel.genres.observe(viewLifecycleOwner, Observer { genres ->
//
//
//            for (i in genres.indices) {
//                if(requireContext() != null && inflater != null && genres[i] != null && storiesViewModel.getComicStoriesByGenre(genres[i]) != null)
//                {
//                    createGridCardViewStory(
//                        requireContext(),
//                        inflater,
//                        linearLayout,
//                        genres[i],
//                        storiesViewModel.getComicStoriesByGenre(genres[i])
//                    )
//                }
//
//
//            }
//
//        })
        ///////////////////////

//       ---------------------------------------------------------------------------------
        // Inflate the layout for this fragment
        return view
    }

    fun toSearchActivity() {
        var intent = Intent(context, SearchActivity::class.java)
        intent.putExtra(getKeyIsComic(requireContext()), isComic)
        startActivity(intent)
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