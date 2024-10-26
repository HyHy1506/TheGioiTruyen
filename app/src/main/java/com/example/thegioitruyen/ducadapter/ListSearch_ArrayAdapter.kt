package com.example.thegioitruyen.ducadapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Filter
import android.widget.TextView
import androidx.annotation.ContentView
import com.example.thegioitruyen.CardStoryItem_DataClass
import org.w3c.dom.Text
import java.util.zip.Inflater
import com.example.thegioitruyen.R

class ListSearch_ArrayAdapter(
    context: Context,private val resource: Int,private val dataList: List<CardStoryItem_DataClass>) :
    ArrayAdapter<CardStoryItem_DataClass>(context,resource,dataList) {
    private var filteredDataList: List<CardStoryItem_DataClass> = dataList.toList()

    override fun getCount(): Int {
        return filteredDataList.size
    }

    override fun getItem(position: Int): CardStoryItem_DataClass? {
        return filteredDataList[position]
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val inflater = LayoutInflater.from(context)
        val view = convertView ?: inflater.inflate(resource, parent, false)

        val item = filteredDataList[position]

        // Ánh xạ các view trong custom_item_layout
        val title = view.findViewById<TextView>(R.id.txtTile_listItemLayout)
        val idStory = view.findViewById<TextView>(R.id.txtIdStory_listItemLayout)

        // Thiết lập dữ liệu
        title.text=item.title
        idStory.text = item.idStory.toString()


        return view
    }

    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                val query = constraint?.toString()?.lowercase() ?: ""

                val filtered = if (query.isEmpty()) {
                    dataList
                } else {
                    dataList.filter {
                        it.title.lowercase().contains(query)
                    }
                }

                val results = FilterResults()
                results.values = filtered
                results.count = filtered.size
                return results
            }

            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                filteredDataList = results?.values as List<CardStoryItem_DataClass>? ?: listOf()
                notifyDataSetChanged()
            }
        }
    }

}