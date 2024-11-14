package com.example.thegioitruyen.ducactivity

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import com.example.thegioitruyen.R
import com.example.thegioitruyen.databinding.ActivityStoriesByGenreBinding
import com.example.thegioitruyen.ducadapter.CardStoryItem_Adapter
import com.example.thegioitruyen.ducdataclass.GenreDataClass
import com.example.thegioitruyen.ducutils.getDataNotFound
import com.example.thegioitruyen.ducutils.getExampleGenre
import com.example.thegioitruyen.ducutils.getKeyGenreInfo
import com.example.thegioitruyen.ducutils.getKeyIsComic
import com.example.thegioitruyen.ducutils.getKeyStoriesByGenre
import com.example.thegioitruyen.ducutils.getTextDataNotFound
import com.example.thegioitruyen.ducviewmodel.StoryViewModel

class StoriesByGenreActivity : AppCompatActivity() {
    private lateinit var binding: ActivityStoriesByGenreBinding
    private val storyViewModel : StoryViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityStoriesByGenreBinding.inflate(layoutInflater)
        val view =binding.root
        enableEdgeToEdge()
        setContentView(view)
        setButtonWithOutData()
        //----------------------

        var keyData= getKeyStoriesByGenre(this)
        if(checkLoadData(keyData)){
            loadData(keyData)

        }else{
            Toast.makeText(this, getDataNotFound(this), Toast.LENGTH_LONG).show()
        }

    }

    private fun loadData(key: String) {
        var bundle= intent.getBundleExtra(key)
        if(bundle is Bundle){
            var isComic =bundle.getBoolean(getKeyIsComic(this))
            var genreInfo: GenreDataClass? = bundle.getParcelable(
                getKeyGenreInfo(this)
            )
            binding.txtTitleGenreStoriesByGenre.text=genreInfo?.title ?: getTextDataNotFound(this)
            setCardStories(isComic,genreInfo?: getExampleGenre(this))
        }
    }

    fun checkLoadData(key: String): Boolean{

        return intent.hasExtra(key)
    }
    private fun setCardStories(isComic: Boolean,genre: GenreDataClass) {
        var dataList=if( isComic)ArrayList( storyViewModel.getComicStoriesByGenre(genre))
        else ArrayList( storyViewModel.getTextStoriesByGenre(genre))
        var adapter = CardStoryItem_Adapter(this, dataList)
        binding.recyclerStoryStoriesByGenre.adapter=adapter
        binding.recyclerStoryStoriesByGenre.layoutManager= GridLayoutManager(this,3,
            GridLayoutManager.VERTICAL,false)
    }

    private fun setButtonWithOutData() {
        binding.btnBackStoriesByGenre.setOnClickListener{
            finish()
        }
    }

}