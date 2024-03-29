package com.football.manager.view.fragments

import android.view.View
import androidx.fragment.app.viewModels
import com.football.manager.R
import com.football.manager.databinding.FragmentRankingBinding
import com.football.manager.view.base.BaseFragment
import com.football.manager.view.recyclerview.LeagueAdapter
import com.football.manager.viewmodel.RankingViewModel
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class RankingFragment : BaseFragment<FragmentRankingBinding>(R.layout.fragment_ranking) {

    private lateinit var adapterLeague: LeagueAdapter

    private val rankingViewModel: RankingViewModel by viewModels()

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
            vm = rankingViewModel
            rankingViewModel.getData(39, 2023)
            toggleGroup.addOnButtonCheckedListener { _, checkedId, isChecked ->
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

            layoutBottom.apply {
                includeChampions.imageState.setBackgroundResource(R.drawable.circle_green)
                includeEuropa.imageState.setBackgroundResource(R.drawable.circle_red)
                includeDemotion.imageState.setBackgroundResource(R.drawable.circle_blue)

                includeChampions.textState.setText(R.string.champions)
                includeEuropa.textState.setText(R.string.europa)
                includeDemotion.textState.setText(R.string.demotion)
            }
        }
    }

    override fun backPressed() {

    }
}