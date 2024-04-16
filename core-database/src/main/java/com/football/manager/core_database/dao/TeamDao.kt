package com.football.manager.core_database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.football.manager.core_database.entity.LeagueEntity

@Dao
interface TeamDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLeagueList(leagueList: List<LeagueEntity>)

    @Query("SELECT * FROM LeagueEntity")
    suspend fun getAllTeamList(): List<LeagueEntity>

    @Query("SELECT * FROM LeagueEntity WHERE season = :season")
    suspend fun getTeamBySeasonList(season: String): List<LeagueEntity>

    @Query("SELECT * FROM LeagueEntity WHERE id = :id AND season = :season")
    suspend fun getTeamList(id: Int, season: String): List<LeagueEntity>
}