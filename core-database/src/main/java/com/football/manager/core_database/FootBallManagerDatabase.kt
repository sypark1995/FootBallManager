package com.football.manager.core_database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.football.manager.core_database.dao.TeamDao
import com.football.manager.core_database.entity.LeagueEntity

@Database(entities = [LeagueEntity::class], version = 1, exportSchema = true)
abstract class FootBallManagerDatabase : RoomDatabase() {

    abstract fun teamDao(): TeamDao
}