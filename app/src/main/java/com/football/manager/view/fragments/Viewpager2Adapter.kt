package com.football.manager.view.fragments

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.football.manager.view.util.MainCategory

class Viewpager2Adapter(fragment : Fragment) :
    FragmentStateAdapter(fragment) {


    override fun getItemCount(): Int {
        return MainCategory.entries.size
    }

    override fun createFragment(position: Int): Fragment {
        when (position) {
            0 -> return RankingFragment()
            1 -> return MatchFragment()
            2 -> return RankingFragment()
        }
        return RankingFragment()
    }
}