package com.football.manager.view.util

import androidx.annotation.StringRes
import com.football.manager.R

enum class League(@StringRes val res: Int, val state: Int, var isSelected: Boolean) {
    EPL(R.string.league_epl, 39, true),
    LALIGA(R.string.league_laliga, 39, false),
    BUNDESLIGA(R.string.league_bundesliga, 39, false),
    LIGUE1(R.string.league_ligue1, 39, false),
    SERIEA(R.string.league_serie_a, 39, false),
}

enum class Years(val years: Int) {

}

val years = listOf<String>("2000", "2001", "2002", "2003")
