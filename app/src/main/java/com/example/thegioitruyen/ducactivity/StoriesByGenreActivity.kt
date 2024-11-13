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

        var keyData=resources.getString(R.string.key_storiesByGenre)
        if(checkLoadData(keyData)){
            loadData(keyData)

        }else{
            Toast.makeText(this,resources.getString(R.string.dataNotFound), Toast.LENGTH_LONG).show()
        }

    }

    private fun loadData(key: String) {
        var bundle= intent.getBundleExtra(key)
        if(bundle is Bundle){
            var isComic =bundle.getBoolean(resources.getString(R.string.key_isComic))
            var genreInfo =bundle.getSerializable(
                resources.getString(R.string.key_genreInfo)
            ) as GenreDataClass
            binding.txtTitleGenreStoriesByGenre.text=genreInfo.title
            setCardStories(isComic,genreInfo)
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