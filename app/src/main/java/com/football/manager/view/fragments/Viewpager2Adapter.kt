package com.football.manager.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class Viewpager2Adapter(fragment : Fragment) :
    FragmentStateAdapter(fragment) {
    private val ARG_OBJECT = "object"

    override fun getItemCount(): Int {
        return 9
    }

    override fun createFragment(position: Int): Fragment {
//        val fragment = MainFragment()
//        fragment.arguments = Bundle().apply {
//            // The object is just an integer.
//            putInt(ARG_OBJECT, position + 1)
//        }
//        return fragment
        when (position) {
            0 -> return MainFragment()
            1 -> return ScheduleFragment()
            2 -> return MainFragment()
        }
        return ScheduleFragment()
    }
}