package com.example.thegioitruyen

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class FragmentPageUserHomeAdapter(fragmentManager: FragmentManager,lifecycle: Lifecycle):
    FragmentStateAdapter(fragmentManager,lifecycle)
{
    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 ->{
                ComicStoriesUserFragment()
            }
            1 ->{
                TextStoriesUserFragment()
            }
            2 ->{
                BookStoriesUserFragment()
            }
            else ->{
                SettingUserFragment()
            }

        }
    }

    override fun getItemCount(): Int {
        return 4
    }
}