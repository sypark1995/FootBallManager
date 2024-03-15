package com.football.manager.view.util

import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import com.football.manager.R
import com.football.manager.view.fragments.MatchFragment
import com.football.manager.view.fragments.RankingFragment

enum class League(@StringRes val res: Int, val state: Int, var isSelected: Boolean) {
    EPL(R.string.league_epl, 39, true),
    LALIGA(R.string.league_laliga, 39, false),
    BUNDESLIGA(R.string.league_bundesliga, 39, false),
    LIGUE1(R.string.league_ligue1, 39, false),
    SERIEA(R.string.league_serie_a, 39, false),
}

val years = listOf<String>("2000", "2001", "2002", "2003")

enum class MainCategory(@StringRes val res: Int, val fragment: Fragment) {
    Ranking(R.string.category_ranking, RankingFragment()),
    Match(R.string.category_match, MatchFragment()),
    News(R.string.category_news, MatchFragment()),
    PlayerStats(R.string.category_player_stats, MatchFragment()),
    TeamStats(R.string.category_team_stats, MatchFragment()),
    WeekTeam(R.string.category_week_team, MatchFragment()),
    Seasons(R.string.category_seasons, MatchFragment());
}