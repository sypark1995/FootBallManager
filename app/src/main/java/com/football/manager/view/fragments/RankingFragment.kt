package com.football.manager.view.fragments

import androidx.fragment.app.viewModels
import com.football.manager.R
import com.football.manager.databinding.FragmentRankingBinding
import com.football.manager.view.base.BaseFragment
import com.football.manager.view.recyclerview.RankingAdapter
import com.football.manager.view.util.ToggleCategory
import com.football.manager.viewmodel.RankingViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RankingFragment : BaseFragment<FragmentRankingBinding>(R.layout.fragment_ranking) {

    private val rankingViewModel: RankingViewModel by viewModels()

    override fun init() {

        binding.apply {
            vm = rankingViewModel
            adapter = RankingAdapter()

            toggleGroup.addOnButtonCheckedListener { _, checkedId, isChecked ->
                if (isChecked) {
                    when (checkedId) {
                        // todo_sypark
                        R.id.button_ranking -> {
                            rankingViewModel.onButtonChecked(ToggleCategory.Ranking)
                        }

                        R.id.button_record -> {
                            rankingViewModel.onButtonChecked(ToggleCategory.Recently)
                        }
                    }
                }
            }
        }
    }

    override fun backPressed() {

    }
}