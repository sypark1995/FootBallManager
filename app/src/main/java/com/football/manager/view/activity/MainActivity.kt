package com.football.manager.view.activity

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.TextView
import coil.load
import com.football.manager.R
import com.football.manager.databinding.ActivityMainBinding
import com.football.manager.view.base.BaseActivity
import com.football.manager.view.fragments.Viewpager2Adapter
import com.football.manager.view.util.MainCategory
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.apply {

            layoutHeader.apply {
                imageLogo.apply {
                    load("https://media.api-sports.io/football/leagues/39.png") {
//                    placeholder()   //대체이미지
//                    error() //Load fail 시 이미지
                    }

                    spinnerSeasons.apply {
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

                pager.apply {
                    adapter = Viewpager2Adapter(supportFragmentManager, lifecycle)
                    offscreenPageLimit = MainCategory.entries.size
                }

                TabLayoutMediator(layoutHeader.tabLayout, pager) { tab, position ->
                    tab.setText(MainCategory.entries[position].res)
                }.attach()


            }
        }
    }
}