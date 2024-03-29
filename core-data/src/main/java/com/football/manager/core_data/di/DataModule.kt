package com.football.manager.core_data.di

import com.football.manager.core_data.repository.RankingRepository
import com.football.manager.core_data.repository.RankingRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface DataModule {

    @Binds
    fun bindRankingRepository(rankingRepositoryImpl: RankingRepositoryImpl): RankingRepository
}