package com.example.thegioitruyen.ducadapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.thegioitruyen.R
import com.example.thegioitruyen.ducdataclass.GenreDataClass

class Button_Adapter(private val dataList: ArrayList<GenreDataClass>) :
    RecyclerView.Adapter<Button_Adapter.ViewHolderClass>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolderClass {
       var itemView = LayoutInflater.from(parent.context).inflate(
           R.layout.genre_item_layout,parent,false)

        return ViewHolderClass(itemView)
    }

    override fun onBindViewHolder(
        holder: ViewHolderClass,
        position: Int
    ) {
        holder.btnGenre.setText(dataList[position].title)
        holder.txtIDGenre.setText(dataList[position].idGenre.toString())
        holder.btnGenre.setOnClickListener{
            Toast.makeText(holder.itemView.context,"bam nut ID: ${dataList[position].idGenre}, ${dataList[position].title}", Toast.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount(): Int {
      return dataList.size
    }

    class ViewHolderClass(itemView : View): RecyclerView.ViewHolder(itemView){
        var btnGenre =itemView.findViewById<Button>(R.id.btn_genreItemlayout)
        var txtIDGenre = itemView.findViewById<TextView>(R.id.txtIDGenre_genreItemlayout)
    }
}