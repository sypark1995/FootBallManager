package com.football.manager.view.fragments

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.football.manager.view.util.MainCategory

class Viewpager2Adapter(fragment: Fragment) :
    FragmentStateAdapter(fragment) {


    override fun getItemCount(): Int {
        return MainCategory.entries.size
    }

    override fun createFragment(position: Int): Fragment {
        return MainCategory.entries[position].fragment
    }
}