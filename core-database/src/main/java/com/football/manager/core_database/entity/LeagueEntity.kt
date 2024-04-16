package com.football.manager.core_database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class LeagueEntity(
    @PrimaryKey
    val seasonId: String,  //season + id
    val id: Long,
    val name: String,
    val logo: String,
    val points: Long,

    val goalsDiff: Long,
    val group: String,
    val form: String,
    val description: String?,
    val allPlayed: Long,

    val allWin: Long,
    val allDraw: Long,
    val allLose: Long,
    val allGoalsFor: Long,
    val allGoalsAgainst: Long,

    val homePlayed: Long,
    val homeWin: Long,
    val homeDraw: Long,
    val homeLose: Long,
    val homeGoalsFor: Long,

    val homeGoalsAgainst: Long,
    val awayPlayed: Long,
    val awayWin: Long,
    val awayDraw: Long,
    val awayLose: Long,

    val awayGoalsFor: Long,
    val awayGoalsAgainst: Long,
    val update: String,
    val season: Long,
    val rank: Long,

    val status: String
)

/*
sealed class League {



    @Entity
    data class LeagueInfoEntity(
        @PrimaryKey
        val id: Int,
        val name: String,
        val logo: String,
        val points: Int,
        val goalsDiff : Int,
        val group: String,
        val form: String,
        val status: String,
        val description: String,
        val home : Home
    ): League()

    @Entity
    data class Home(
        val played: Long,
        val win: Long,
        val draw: Long,
        val lose: Long,
        val goals: Goals,
    ): League()

    @Entity
    data class Away(
        val played: Long,
        val win: Long,
        val draw: Long,
        val lose: Long,
        val goals: Goals,
    ): League()

    @Entity
    data class All(
        val played: Long,
        val win: Long,
        val draw: Long,
        val lose: Long,
        val goals: Goals,
    ): League()

}*/
