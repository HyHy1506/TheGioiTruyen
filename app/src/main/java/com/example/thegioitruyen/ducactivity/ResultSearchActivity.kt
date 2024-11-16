package com.example.thegioitruyen.ducactivity

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.thegioitruyen.R
import com.example.thegioitruyen.databinding.ActivityResultSearchBinding
import com.example.thegioitruyen.ducadapter.CardStoryItem_Adapter
import com.example.thegioitruyen.ducdataclass.StoryDataClass
import com.example.thegioitruyen.ducutils.getDataNotFound
import com.example.thegioitruyen.ducutils.getKeyIsComic
import com.example.thegioitruyen.ducutils.getKeyResultSearchInfo
import com.example.thegioitruyen.ducutils.getKeyTextQuery
import com.example.thegioitruyen.ducutils.getTextDataNotFound
import com.example.thegioitruyen.ducviewmodel.StoryViewModel
import com.example.thegioitruyen.ducviewmodelfactory.StoryViewModelFactory

class ResultSearchActivity : AppCompatActivity() {
    private lateinit var binding: ActivityResultSearchBinding
    private lateinit var dataList: ArrayList< StoryDataClass>
    private lateinit var textQuery: String
    private var isComic : Boolean=true
    private val storyViewModel: StoryViewModel by viewModels{
        StoryViewModelFactory(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding= ActivityResultSearchBinding.inflate(layoutInflater)
        val view =binding.root
        enableEdgeToEdge()
        setContentView(view)
        //===============================
        if(isCheckLoad(getKeyResultSearchInfo(this))==false){return}

        loadData()
        setData()
        setConfigButton()


    }

    private fun setData() {
        var cardStoryAdapter= CardStoryItem_Adapter(this,ArrayList(storyViewModel.getStoriesByQuery(textQuery,isComic)))
        var recyclerView: RecyclerView=binding.recyclerStoriesResultSearch
        recyclerView.adapter=cardStoryAdapter
        recyclerView.layoutManager= GridLayoutManager(this,3, LinearLayoutManager.VERTICAL,false)
        //recyclerView.setHasFixedSize(true)
    }

    private fun setConfigButton() {
        binding.btnBackResultSearch.setOnClickListener{
            finish()
        }
    }

    private fun isCheckLoad(key: String): Boolean {
        return intent.hasExtra(key)
    }
    private fun loadData(){
        var bundle=intent.getBundleExtra(getKeyResultSearchInfo(this))
        if(bundle!=null)
        {
            isComic=bundle.getBoolean(getKeyIsComic(this))
            textQuery=bundle.getString(getKeyTextQuery(this))?: getDataNotFound(this)

        }
    }
}