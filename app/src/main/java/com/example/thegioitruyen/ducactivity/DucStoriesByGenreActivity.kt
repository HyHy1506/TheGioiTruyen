package com.example.thegioitruyen.ducactivity

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.example.thegioitruyen.databinding.ActivityDucStoriesByGenreBinding
import com.example.thegioitruyen.ducadapter.Duc_CardStoryItem_Adapter
import com.example.thegioitruyen.ducdataclass.DucGenreDataClass
import com.example.thegioitruyen.ducutils.getDataNotFound
import com.example.thegioitruyen.ducutils.getExampleGenre
import com.example.thegioitruyen.ducutils.getKeyGenreInfo
import com.example.thegioitruyen.ducutils.getKeyIsComic
import com.example.thegioitruyen.ducutils.getKeyStoriesByGenre
import com.example.thegioitruyen.ducutils.getTextDataNotFound
import com.example.thegioitruyen.ducviewmodel.DucStoryViewModel
import com.example.thegioitruyen.ducviewmodelfactory.DucStoryViewModelFactory

class DucStoriesByGenreActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDucStoriesByGenreBinding
    private val ducStoryViewModel: DucStoryViewModel by viewModels{
        DucStoryViewModelFactory(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityDucStoriesByGenreBinding.inflate(layoutInflater)
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
            var genreInfo: DucGenreDataClass? = bundle.getParcelable(
                getKeyGenreInfo(this)
            )
            binding.txtTitleGenreStoriesByGenre.text=genreInfo?.title ?: getTextDataNotFound(this)
            setCardStories(isComic,genreInfo?: getExampleGenre(this))
        }
    }

    fun checkLoadData(key: String): Boolean{

        return intent.hasExtra(key)
    }
    private fun setCardStories(isComic: Boolean,genre: DucGenreDataClass) {
        var dataList=if( isComic)ArrayList( ducStoryViewModel.getComicStoriesByGenre(genre))
        else ArrayList( ducStoryViewModel.getTextStoriesByGenre(genre))
        var adapter = Duc_CardStoryItem_Adapter(this, dataList)
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