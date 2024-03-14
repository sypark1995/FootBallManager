package com.football.manager.view.activity

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.football.manager.view.base.BaseActivity
import com.football.manager.R
import com.football.manager.databinding.ActivityMainBinding
import com.football.manager.view.fragments.MainFragment

class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.lifecycleOwner = this

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_main_fragment) as NavHostFragment
        navController = navHostFragment.navController
        val navGraph = navController.navInflater.inflate(R.navigation.nav_graph)

        navGraph.setStartDestination(R.id.mainFragment)

        navController.graph = navGraph
        binding.apply {
            if (savedInstanceState == null) {
                replaceFragment(MainFragment())
            }
        }

//        binding.layoutBottom.navBottom.run {
//            setOnItemSelectedListener {
//                when (it.itemId) {
//                    R.id.menu_news -> {
//                        replaceFragment(MainFragment())
//                    }
//
//                    R.id.menu_schedule -> {
//                        replaceFragment(ScheduleFragment())
//                    }
//
//                    R.id.menu_ranking -> {
//                        replaceFragment(MainFragment())
//                    }
//
//                    else -> {
//                        return@setOnItemSelectedListener false
//                    }
//                }
//
//                return@setOnItemSelectedListener true
//            }
//        }
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.nav_host_main_fragment, fragment)
            .commit()
    }
}