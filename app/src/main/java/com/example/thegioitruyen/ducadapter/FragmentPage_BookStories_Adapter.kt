package com.example.thegioitruyen.ducadapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.thegioitruyen.LoveBookStoriesFragment
import com.example.thegioitruyen.ReadBookStoriesFragment

class FragmentPage_BookStories_Adapter(fragmentManager: FragmentManager,lifeCycle: Lifecycle)
    : FragmentStateAdapter(fragmentManager,lifeCycle) {
    override fun createFragment(position: Int): Fragment {
        return when(position){
            0->{
                ReadBookStoriesFragment()
            }else -> {
                LoveBookStoriesFragment()
            }
        }
    }

    override fun getItemCount(): Int {
       return 2
    }


}