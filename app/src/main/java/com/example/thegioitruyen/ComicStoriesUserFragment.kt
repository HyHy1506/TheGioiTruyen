package com.example.thegioitruyen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ComicStoriesUserFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ComicStoriesUserFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var recyclerView: RecyclerView
    private lateinit var dataList: ArrayList<CardStoryItemDataClass>
    private lateinit var titleList: Array<String>
    private lateinit var authorList: Array<String>
    private lateinit var imgUrlList: Array<Int>
    private lateinit var scoreList: Array<Float>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
        titleList=arrayOf(
            "Cau chuyen",
            "Xua kia",
            "Muon Thua Khac Ghi Nao",
            "Ai oi3",
            "Ai oi1",
            "Ai oi3",
            "Ai oi1",
            "Ai oi2"
        )
        authorList=arrayOf(
            "A",
            "B",
            "C",
            "d",
            "E",
            "d",
            "E",
            "sad fdsfe gẻ áda ád ád hth htht ól jẻh"
        )
        imgUrlList=arrayOf(
            R.drawable.a1,
            R.drawable.a2,
            R.drawable.a3,
            R.drawable.a4,
            R.drawable.a5,
            R.drawable.a4,
            R.drawable.a5,
            R.drawable.a6,
        )
        scoreList=arrayOf(
            3.5f,
            4f,
            5f,
            1f,
            4.5f,
            1f,
            4.5f,
            2f
        )

    }
    fun getData(){
        for(i in titleList.indices){
            var dataClas= CardStoryItemDataClass(titleList[i],
                authorList[i],imgUrlList[i],scoreList[i])
            dataList.add(dataClas)
        }
        recyclerView.adapter= CardStoryItemAdapter(dataList)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =inflater.inflate(R.layout.fragment_comic_stories_user, container, false)
        recyclerView =view.findViewById<RecyclerView>(R.id.recyclerViewComicStoriesUser)
        recyclerView.layoutManager= GridLayoutManager(requireContext(),2, RecyclerView.HORIZONTAL,false)
        dataList= arrayListOf()
        getData()
        // Inflate the layout for this fragment
        return view
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
            ComicStoriesUserFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}