package com.football.manager.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.football.manager.R
import com.google.android.material.bottomnavigation.BottomNavigationView

abstract class BaseFragment<T : ViewDataBinding>(@LayoutRes val layoutResId: Int) : Fragment() {

    private var _binding: T? = null
    protected val binding get() = _binding!!
    private lateinit var onBackPressedCallback: OnBackPressedCallback

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = DataBindingUtil.inflate(inflater, layoutResId, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.lifecycleOwner = viewLifecycleOwner
        view.findViewById<BottomNavigationView>(R.id.nav_bottom)?.run {
            if (initNavButtonId() != null) {
                this.selectedItemId = initNavButtonId()!!
            }

            setOnItemSelectedListener {
                val fragmentId = when (it.itemId) {
                    R.id.menu_news -> {
                        R.id.mainFragment
                    }

                    R.id.menu_ranking -> {
                        R.id.mainFragment
                    }

                    R.id.menu_schedule -> {
                        R.id.mainFragment
                    }

                    else -> {
                        return@setOnItemSelectedListener false
                    }
                }

                findNavController().navigate(fragmentId)
                return@setOnItemSelectedListener true
            }
        }

        onBackPressedCallback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                // Let the derived fragment handle the back button press
                backPressed()
            }
        }

        requireActivity().onBackPressedDispatcher.addCallback(
            viewLifecycleOwner,
            onBackPressedCallback
        )

        init(view)
    }

    protected abstract fun init(view: View)

    abstract fun backPressed()
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
        onBackPressedCallback.remove()
    }

    protected open fun initNavButtonId(): Int? = null
}