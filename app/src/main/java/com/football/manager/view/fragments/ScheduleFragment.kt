package com.football.manager.view.fragments

import android.view.View
import com.football.manager.R
import com.football.manager.databinding.FragmentScheduleBinding
import com.football.manager.view.BaseFragment
import com.football.manager.view.recyclerview.LeagueAdapter
import com.football.manager.view.util.League

class ScheduleFragment : BaseFragment<FragmentScheduleBinding>(R.layout.fragment_schedule) {

    private lateinit var adapterLeague: LeagueAdapter

    override fun init(view: View) {
        binding.apply {
            layoutBottom.navBottom.menu.getItem(1).isChecked = true
            adapterLeague = LeagueAdapter {

            }
            recyclerviewLeague.apply {
                adapter = adapterLeague
                adapterLeague.submitList(League.entries)

            }
        }
    }

    override fun backPressed() {

    }
}