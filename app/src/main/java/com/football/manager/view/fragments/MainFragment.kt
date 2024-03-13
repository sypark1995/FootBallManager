package com.football.manager.view.fragments

import android.view.View
import android.view.ViewParent
import android.widget.ArrayAdapter
import coil.load
import com.football.manager.R
import com.football.manager.databinding.FragmentMainBinding
import com.football.manager.view.base.BaseFragment
import com.google.android.material.tabs.TabLayoutMediator

class MainFragment : BaseFragment<FragmentMainBinding>(R.layout.fragment_main) {

    override fun init(view: View) {
        binding.apply {
            layoutHeader.imageLogo.apply {
                load("https://media.api-sports.io/football/leagues/39.png")
            }

            ArrayAdapter.createFromResource(
                root.context,
                R.array.season_array,
                R.layout.item_spinner
            ).also {
                it.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                layoutHeader.spinnerSeasons.adapter = it
            }
//
            pager.adapter = Viewpager2Adapter(this@MainFragment)
            TabLayoutMediator(layoutHeader.tabLayout, pager) { tab, position ->
                tab.text = "POSITION ${(position + 1)}"
            }.attach()
        }
    }

    override fun backPressed() {

    }
}