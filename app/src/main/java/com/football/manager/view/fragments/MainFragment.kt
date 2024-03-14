package com.football.manager.view.fragments

import android.graphics.Color
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.TextView
import coil.load
import com.football.manager.R
import com.football.manager.databinding.FragmentMainBinding
import com.football.manager.view.base.BaseFragment
import com.football.manager.view.util.MainCategory
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
                android.R.layout.simple_spinner_item
            ).also {
                it.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                layoutHeader.spinnerSeasons.adapter = it
            }
//
            pager.adapter = Viewpager2Adapter(this@MainFragment)
            TabLayoutMediator(layoutHeader.tabLayout, pager) { tab, position ->
                tab.setText(MainCategory.entries[position].res)
            }.attach()

            layoutHeader.spinnerSeasons.apply {
                onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                    override fun onItemSelected(
                        parent: AdapterView<*>?,
                        view: View?,
                        position: Int,
                        id: Long
                    ) {
                        (view as TextView).setTextColor(Color.WHITE)
                    }

                    override fun onNothingSelected(parent: AdapterView<*>?) {
                    }

                }
            }
        }
    }

    override fun backPressed() {

    }
}