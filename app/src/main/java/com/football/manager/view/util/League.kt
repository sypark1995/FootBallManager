package com.football.manager.view.util

import androidx.annotation.StringRes
import com.football.manager.R

enum class League(@StringRes val res: Int, val state: Int) {
    EPL(R.string.league_epl, 39),
    LALIGA(R.string.league_laliga, 39),
    BUNDESLIGA(R.string.league_bundesliga, 39),
    LIGUE1(R.string.league_ligue1, 39),
    SERIEA(R.string.league_serie_a, 39),
}

enum class Years(val years: Int) {

}

