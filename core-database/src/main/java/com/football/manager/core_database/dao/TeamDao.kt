package com.football.manager.core_database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.football.manager.core_database.entity.LeagueEntity

@Dao
interface TeamDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertLeagueList(leagueList: List<LeagueEntity>)

    @Query("SELECT * FROM LeagueEntity")
    fun getAllTeamList(): List<LeagueEntity>

    @Query("SELECT * FROM LeagueEntity WHERE season = :season")
    fun getTeamBySeasonList(season: String): List<LeagueEntity>

    @Query("SELECT * FROM LeagueEntity WHERE id = :id AND season = :season")
    fun getTeamList(id: Int, season: String): List<LeagueEntity>
}