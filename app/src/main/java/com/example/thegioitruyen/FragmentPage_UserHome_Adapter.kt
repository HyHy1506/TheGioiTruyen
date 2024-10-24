package com.example.thegioitruyen

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class FragmentPage_UserHome_Adapter(fragmentManager: FragmentManager, lifecycle: Lifecycle):
    FragmentStateAdapter(fragmentManager,lifecycle)
{
    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 ->{
                ComicStories_User_Fragment()
            }
            1 ->{
                TextStories_User_Fragment()
            }
            2 ->{
                BookStories_User_Fragment()
            }
            else ->{
                Setting_User_Fragment()
            }

        }
    }

    override fun getItemCount(): Int {
        return 4
    }
}