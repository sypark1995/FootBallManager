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

enum class Years(val data: String, val years: Int) {
    A("2023/2024", 2023),
    B("2022/2023", 2022),
    C("2021/2022", 2021),
    D("2020/2021", 2020),
    E("2019/2020", 2019),
    F("2018/2019", 2018),
    G("2017/2018", 2017),
    H("2016/2017", 2016),
    I("2015/2016", 2015),
    J("2014/2015", 2014),
    K("2013/2014", 2013),
    M("2012/2013", 2012),
    N("2011/2012", 2011),
    O("2010/2011", 2010)
}

val years = listOf<String>("2000", "2001", "2002", "2003")

enum class MainCategory(@StringRes val res: Int) {
    Ranking(R.string.category_ranking),
    Match(R.string.category_match),
    News(R.string.category_news),
    PlayerStats(R.string.category_player_stats),
    TeamStats(R.string.category_team_stats),
    WeekTeam(R.string.category_week_team),
    Seasons(R.string.category_seasons)
}
