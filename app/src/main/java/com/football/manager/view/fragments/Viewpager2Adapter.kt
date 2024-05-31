package com.football.manager.view.fragments

import android.util.SparseArray
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.football.manager.view.util.MainCategory

class Viewpager2Adapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fragmentManager, lifecycle) {
    private val fragments: SparseArray<Fragment> = SparseArray()

    override fun getItemCount(): Int {
        return MainCategory.entries.size
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> RankingFragment().also {
                fragments.append(position, it)
            }

            1 -> MatchFragment().also {
                fragments.append(position, it)
            }

            2 -> MatchFragment().also {
                fragments.append(position, it)
            }

            3 -> MatchFragment().also {
                fragments.append(position, it)
            }

            4 -> MatchFragment().also {
                fragments.append(position, it)
            }

            5 -> MatchFragment().also {
                fragments.append(position, it)
            }

            6 -> MatchFragment().also {
                fragments.append(position, it)
            }

            else -> throw IllegalArgumentException("Invalid position")
        }
    }
}