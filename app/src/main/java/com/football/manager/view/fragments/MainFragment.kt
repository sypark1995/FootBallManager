package com.football.manager.view.fragments

import android.view.View
import com.football.manager.R
import com.football.manager.databinding.FragmentMainBinding
import com.football.manager.view.base.BaseFragment

class MainFragment : BaseFragment<FragmentMainBinding>(R.layout.fragment_main) {

    override fun init(view: View) {
        binding.apply {
//            layoutBottom.navBottom.menu.getItem(0).isChecked = true
        }
    }

    override fun backPressed() {

    }
}