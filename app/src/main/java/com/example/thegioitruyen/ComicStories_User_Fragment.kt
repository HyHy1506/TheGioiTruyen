package com.example.thegioitruyen


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.GridLayout
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.ListView
import android.widget.SearchView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.thegioitruyen.ducadapter.Button_Adapter
import com.example.thegioitruyen.ducadapter.ListSearch_ArrayAdapter

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

    private lateinit var searchView: SearchView
    private lateinit var listViewSearchResults: ListView
    private lateinit var searchAdapter: ListSearch_ArrayAdapter


    private lateinit var dataList: ArrayList<CardStoryItem_DataClass>
    private lateinit var genreList: ArrayList<String>



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
         searchView =view.findViewById<SearchView>(R.id.search_comicStoriesUser)
        listViewSearchResults =view.findViewById<ListView>(R.id.listSearch_comicStoriesUser)
        recyclerViewGenreButton =view.findViewById<RecyclerView>(R.id.rv_buttonGenre_ComicStoriesUser)
        SampleDataStory.generateData()
        SampleDataStory.generateListOfGenre()
        dataList = ArrayList(SampleDataStory.getDataList())
        genreList = ArrayList(SampleDataStory.getListOfGenre())

        searchAdapter = ListSearch_ArrayAdapter(view.context,R.layout.list_item_search_layout,dataList)
        listViewSearchResults.adapter=searchAdapter
        ///////////////////////
        recyclerViewGenreButton.layoutManager= GridLayoutManager(view.context,1, GridLayoutManager.HORIZONTAL,false)
        recyclerViewGenreButton.adapter= Button_Adapter(genreList)

        for(i in genreList.indices)
        {
            linearLayout.addView(creatGridCardViewStory(genreList[i],inflater,container))

        }
        searchView.suggestionsAdapter = null
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                searchView.clearFocus()
                listViewSearchResults.visibility= View.GONE
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                if(newText.isNullOrEmpty())
                {
                    listViewSearchResults.visibility= View.GONE

                }else{
                    listViewSearchResults.visibility= View.VISIBLE
                    searchAdapter.filter.filter(newText)

                    updateListViewHeight(listViewSearchResults)
                }

                return true;
            }

        })
        searchView.setOnCloseListener{
            searchView.clearFocus()
            listViewSearchResults.visibility= View.GONE
            true
        }

        ///////////////////////

//       ---------------------------------------------------------------------------------
        // Inflate the layout for this fragment
        return view
    }


    fun creatGridCardViewStory(genre: String, inflater:LayoutInflater,container: ViewGroup?): View{
        val listCardStoriesLayout = inflater.inflate(R.layout.list_card_stories_layout,container,false)
        var gridLayout=listCardStoriesLayout.findViewById<GridLayout>(R.id.gridLayout_listCardStory)
        var txtGenre=listCardStoriesLayout.findViewById<TextView>(R.id.genre_listCardStory)

        for ( i in 0..5){

            var cardView =inflater.inflate(R.layout.card_story_item_layout,container,false)
            var title=cardView.findViewById<TextView>(R.id.txtTitleCardStoryItemLayout)
            var author =cardView.findViewById<TextView>(R.id.txtAuthorCardStoryItemLayout)
            var imgURL=cardView.findViewById<ImageView>(R.id.imgCardStoryItemLayout)
            var score =cardView.findViewById<TextView>(R.id.txtRankCardStoryItemLayout)
            var idStory =cardView.findViewById<TextView>(R.id.idStory_CardStoryItem)

            title.text=dataList[i].title
            author.text=dataList[i].author
            imgURL.setImageResource(dataList[i].imgURL)

            score.text= (dataList[i].score).toString()
            idStory.text=dataList[i].idStory.toString()
            cardView.setOnClickListener({
                Toast.makeText(requireContext(),"ID: ${idStory.text}- ${title.text}", Toast.LENGTH_SHORT).show()
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
        return listCardStoriesLayout
    }
    fun updateListViewHeight(listView: ListView) {
        val adapter = listView.adapter ?: return
        var totalHeight = 0
        for (i in 0 until adapter.count) {
            val listItem = adapter.getView(i, null, listView)
            listItem.measure(
                View.MeasureSpec.makeMeasureSpec(listView.width, View.MeasureSpec.EXACTLY),
                View.MeasureSpec.UNSPECIFIED
            )
            totalHeight += listItem.measuredHeight
        }
        val params = listView.layoutParams
        params.height = totalHeight + (listView.dividerHeight * (adapter.count - 1))
        listView.layoutParams = params
        listView.requestLayout()
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