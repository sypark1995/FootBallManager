package com.football.manager.core_database.mapper

import com.football.manager.core_database.entity.LeagueEntity
import com.football.manager.core_network.model.detail.All
import com.football.manager.core_network.model.detail.Away
import com.football.manager.core_network.model.detail.Goals
import com.football.manager.core_network.model.detail.Home
import com.football.manager.core_network.model.detail.Standing
import com.football.manager.core_network.model.detail.Team

object LeagueInfoEntityMapper : EntityMapper<List<Standing>, List<LeagueEntity>> {
    override fun asEntity(season: Long, domain: List<Standing>): List<LeagueEntity> {
        return domain.map {
            LeagueEntity(
                seasonId = season.toString() + "_" + it.team.id,
                id = it.team.id,
                name = it.team.name,
                logo = it.team.logo,
                points = it.points,

                goalsDiff = it.goalsDiff,
                group = it.group,
                form = it.form,
                description = it.description,
                allPlayed = it.all.played,

                allWin = it.all.win,
                allDraw = it.all.draw,
                allLose = it.all.lose,
                allGoalsFor = it.all.goals.for_field,
                allGoalsAgainst = it.all.goals.against,

                homePlayed = it.home.played,
                homeWin = it.home.win,
                homeDraw = it.home.draw,
                homeLose = it.home.lose,
                homeGoalsAgainst = it.home.goals.against,

                homeGoalsFor = it.home.goals.for_field,
                awayPlayed = it.away.played,
                awayWin = it.away.win,
                awayDraw = it.away.draw,
                awayLose = it.away.lose,

                awayGoalsFor = it.away.goals.for_field,
                awayGoalsAgainst = it.away.goals.against,
                update = it.update,
                season = season,
                rank = it.rank,
                status = it.status
            )
        }
    }

    override fun asDomain(entity: List<LeagueEntity>): List<Standing> {
        return entity.map {
            Standing(
                rank = it.rank,
                team = Team(id = it.id, name = it.name, logo = it.logo),
                points = it.points,
                goalsDiff = it.goalsDiff,
                group = it.group,
                form = it.form,
                status = it.status,
                description = it.description,
                all = All(
                    played = it.allPlayed,
                    win = it.allWin,
                    draw = it.allDraw,
                    lose = it.allLose,
                    goals = Goals(
                        for_field = it.allGoalsFor,
                        against = it.allGoalsAgainst
                    )
                ),
                home = Home(
                    played = it.homePlayed,
                    win = it.homeWin,
                    draw = it.homeDraw,
                    lose = it.homeLose,
                    goals = Goals(
                        for_field = it.homeGoalsFor,
                        against = it.homeGoalsAgainst
                    )
                ),
                away = Away(
                    played = it.awayPlayed,
                    win = it.awayWin,
                    draw = it.awayDraw,
                    lose = it.awayLose,
                    goals = Goals(
                        for_field = it.awayGoalsFor,
                        against = it.awayGoalsAgainst
                    )
                ),
                update = it.update
            )
        }
    }
}

fun List<Standing>.asEntity(season: Long): List<LeagueEntity> {
    return LeagueInfoEntityMapper.asEntity(season, this)
}

fun List<LeagueEntity>.asDomain(): List<Standing> {
    return LeagueInfoEntityMapper.asDomain(this)
}