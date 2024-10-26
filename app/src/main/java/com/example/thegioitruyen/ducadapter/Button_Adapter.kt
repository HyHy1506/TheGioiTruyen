package com.example.thegioitruyen.ducadapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import com.example.thegioitruyen.R

class Button_Adapter(private val dataList: ArrayList<String>) :
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
        holder.btnGenre.setText(dataList[position])
    }

    override fun getItemCount(): Int {
      return dataList.size
    }

    class ViewHolderClass(itemView : View): RecyclerView.ViewHolder(itemView){
        var btnGenre =itemView.findViewById<Button>(R.id.btn_genreItemlayout)
    }
}