package com.example.thegioitruyen.ducactivity

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ListView
import android.widget.SearchView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.thegioitruyen.R
import com.example.thegioitruyen.SampleDataStory
import com.example.thegioitruyen.databinding.ActivitySearchBinding
import com.example.thegioitruyen.ducadapter.ListSearch_ArrayAdapter
import com.example.thegioitruyen.ducdataclass.CardStoryItem_DataClass

class SearchActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySearchBinding
    private lateinit var searchView: SearchView
    private lateinit var listViewSearchResults: ListView
    private lateinit var searchAdapter: ListSearch_ArrayAdapter
    private lateinit var dataList: ArrayList<CardStoryItem_DataClass>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySearchBinding.inflate(layoutInflater)
        val view = binding.root
        enableEdgeToEdge()
        setContentView(view)
        //----------------
        dataList = ArrayList(SampleDataStory.getDataList())


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
                    var intent = Intent(view.context, ResultSearchActivity::class.java)
                    startActivity(intent)
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
}