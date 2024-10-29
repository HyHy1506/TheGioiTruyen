package com.example.thegioitruyen.ducadapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.thegioitruyen.ducdataclass.CardStoryItem_DataClass
import com.example.thegioitruyen.R


class CardStoryItem_Adapter(private val dataList: ArrayList<CardStoryItem_DataClass>)
    : RecyclerView.Adapter<CardStoryItem_Adapter.ViewHolderClass>(){
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolderClass {
        var itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.card_story_item_layout,
            parent,false)
        return ViewHolderClass(itemView)
    }

    override fun onBindViewHolder(
        holder: ViewHolderClass,
        position: Int
    ) {
        var currentItem = dataList[position]
        holder.title.text=currentItem.title
        holder.author.text=currentItem.author
        holder.imgURL.setImageResource(currentItem.imgURL)

        holder.score.text= (currentItem.score).toString()

    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    class ViewHolderClass(itemView : View): RecyclerView.ViewHolder(itemView){
        var title=itemView.findViewById<TextView>(R.id.txtTitleCardStoryItemLayout)
        var author =itemView.findViewById<TextView>(R.id.txtAuthorCardStoryItemLayout)
        var imgURL=itemView.findViewById<ImageView>(R.id.imgCardStoryItemLayout)
        var score =itemView.findViewById<TextView>(R.id.txtRankCardStoryItemLayout)
    }

}
