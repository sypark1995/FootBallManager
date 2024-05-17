package com.football.manager.view.activity

import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import com.football.manager.view.base.BaseActivity
import com.football.manager.R
import com.football.manager.databinding.ActivityIntroBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@AndroidEntryPoint
class IntroActivity : BaseActivity<ActivityIntroBinding>(R.layout.activity_intro) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        lifecycleScope.launch {
            delay(1000)
            Intent(this@IntroActivity, MainActivity::class.java).run {
                startActivity(this)

                finish()
            }
        }
    }
}