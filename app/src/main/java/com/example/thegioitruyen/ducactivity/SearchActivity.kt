package com.example.thegioitruyen.ducactivity

import android.content.Intent
import android.content.res.Resources
import android.os.Bundle
import android.view.View
import android.widget.ListView
import android.widget.SearchView
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.thegioitruyen.R
import com.example.thegioitruyen.databinding.ActivitySearchBinding
import com.example.thegioitruyen.ducadapter.ListSearch_ArrayAdapter
import com.example.thegioitruyen.ducdataclass.StoryDataClass
import com.example.thegioitruyen.ducutils.getKeyIsComic
import com.example.thegioitruyen.ducutils.getKeyResultSearchInfo
import com.example.thegioitruyen.ducutils.getKeyTextQuery

import com.example.thegioitruyen.ducutils.showTestToast
import com.example.thegioitruyen.ducutils.toActivity
import com.example.thegioitruyen.ducviewmodel.StoryViewModel
import com.example.thegioitruyen.ducviewmodelfactory.StoryViewModelFactory

class SearchActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySearchBinding
    private lateinit var searchView: SearchView
    private lateinit var listViewSearchResults: ListView
    private lateinit var searchAdapter: ListSearch_ArrayAdapter
    private lateinit var dataList: ArrayList<StoryDataClass>
    private val storyViewModel: StoryViewModel by viewModels{
        StoryViewModelFactory(this)
    }
    private var isComic: Boolean = true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySearchBinding.inflate(layoutInflater)
        val view = binding.root
        enableEdgeToEdge()
        setContentView(view)
        //----------------
        var key = getKeyIsComic(this)
        // neu khong biet la tim kiem comic hay text
        if (checkLoadData(key) == false) {
            return
        }
        isComic = intent.getBooleanExtra(key, true)

        dataList = if (isComic) ArrayList(storyViewModel.getComicStories())
        else ArrayList(storyViewModel.getTextStories())



        searchView = binding.searchViewSearch
        listViewSearchResults = binding.listViewSearch
        searchAdapter = ListSearch_ArrayAdapter(
            view.context, R.layout.list_item_search_layout, dataList
        )
        listViewSearchResults.adapter = searchAdapter
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                searchView.clearFocus()
                listViewSearchResults.visibility = View.GONE
                if (!query.isNullOrEmpty()) {
                    toResultSearchActivity(query)
                }
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                if (newText.isNullOrEmpty()) {
                    listViewSearchResults.visibility = View.GONE


                } else {
                    listViewSearchResults.visibility = View.VISIBLE
                    searchAdapter.filter.filter(newText)
                    listViewSearchResults.invalidate()
                    // updateListViewHeight(listViewSearchResults)
                }

                return true;
            }
        })
        searchView.setOnCloseListener {
            searchView.clearFocus()
            listViewSearchResults.visibility = View.GONE
            true
        }

    }

    private fun checkLoadData(key: String): Boolean {
        return intent.hasExtra(key)
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

    fun toResultSearchActivity(textQuery: String) {

        var bundle = createBundle(textQuery)
        toActivity(ResultSearchActivity::class.java, getKeyResultSearchInfo(this), bundle)
    }

    fun createBundle(textQuery: String): Bundle {


        var bundle = Bundle()
        bundle.putBoolean(getKeyIsComic(this), isComic)
        bundle.putString(getKeyTextQuery(this), textQuery)
        return bundle
    }
}