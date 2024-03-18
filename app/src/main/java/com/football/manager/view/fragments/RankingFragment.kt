package com.football.manager.view.fragments

import android.view.View
import com.football.manager.R
import com.football.manager.databinding.FragmentRankingBinding
import com.football.manager.view.base.BaseFragment
import com.football.manager.view.recyclerview.LeagueAdapter
import timber.log.Timber

class RankingFragment : BaseFragment<FragmentRankingBinding>(R.layout.fragment_ranking) {

    private lateinit var adapterLeague: LeagueAdapter

    override fun init(view: View) {
        binding.apply {
//            layoutBottom.navBottom.menu.getItem(1).isChecked = true
//            recyclerviewLeague.apply {
//                adapterLeague = LeagueAdapter {
//                    Timber.e("result $it")
//                }
//
//                adapter = adapterLeague
//                adapterLeague.submitList(League.entries)
//
//            }
            toggleGroup.addOnButtonCheckedListener { group, checkedId, isChecked ->
                if (isChecked) {
                    when (checkedId) {
                        // todo_sypark
                        R.id.button_ranking -> {
                            Timber.e("ranking")
                        }

                        R.id.button_record -> {
                            Timber.e("record")
                        }
                    }
                }
            }
        }
    }

    override fun backPressed() {

    }
}