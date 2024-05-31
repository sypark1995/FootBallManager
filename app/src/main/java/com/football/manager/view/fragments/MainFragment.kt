package com.football.manager.view.fragments

import com.football.manager.R
import com.football.manager.databinding.FragmentMainBinding
import com.football.manager.view.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : BaseFragment<FragmentMainBinding>(R.layout.fragment_main) {

    override fun init() {

        binding.apply {
//            layoutHeader.imageLogo.apply {
//                load("https://media.api-sports.io/football/leagues/39.png") {
////                    placeholder()   //대체이미지
////                    error() //Load fail 시 이미지
//                }
//            }

//            ArrayAdapter.createFromResource(
//                root.context,
//                R.array.season_array,
//                android.R.layout.simple_spinner_item
//            ).also {
//                it.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
//                layoutHeader.spinnerSeasons.adapter = it
//            }
//

//            pager.adapter = Viewpager2Adapter(parentFragmentManager, lifecycle)
//            TabLayoutMediator(layoutHeader.tabLayout, pager) { tab, position ->
//                tab.setText(MainCategory.entries[position].res)
//            }.attach()
//
//            layoutHeader.spinnerSeasons.apply {
//                onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
//                    override fun onItemSelected(
//                        parent: AdapterView<*>?,
//                        view: View?,
//                        position: Int,
//                        id: Long
//                    ) {
//                        (view as TextView).setTextColor(Color.WHITE)
//                    }
//
//                    override fun onNothingSelected(parent: AdapterView<*>?) {
//                    }
//
//                }
//            }
        }
    }

    override fun backPressed() {

    }
}