package com.football.manager.core_database.di

import android.app.Application
import androidx.room.Room
import com.football.manager.core_database.FootBallManagerDatabase
import com.football.manager.core_database.dao.TeamDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideAppDatabase(
        application: Application
    ): FootBallManagerDatabase {
        return Room.databaseBuilder(application, FootBallManagerDatabase::class.java, "FootBall.db")
            .fallbackToDestructiveMigration().build()
    }

    @Provides
    @Singleton
    fun provideTeamDao(database: FootBallManagerDatabase): TeamDao {
        return database.teamDao()
    }
}