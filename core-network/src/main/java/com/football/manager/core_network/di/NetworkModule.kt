package com.football.manager.core_network.di

import com.football.manager.core_network.interceptor.HttpRequestInterceptor
import com.football.manager.core_network.service.RetrofitClient
import com.football.manager.core_network.service.RetrofitService
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {


    @Provides
    @Singleton
    fun provideOKHttpClient(): OkHttpClient {
        return OkHttpClient.Builder().addInterceptor(HttpRequestInterceptor()).build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl("https://v3.football.api-sports.io/")
            .addConverterFactory(
                MoshiConverterFactory.create(
                    Moshi.Builder()
                        .add(KotlinJsonAdapterFactory())
                        .build()
                )
            ).build()
    }

    @Provides
    @Singleton
    fun provideService(retrofit: Retrofit): RetrofitService {
        return retrofit.create(RetrofitService::class.java)
    }

    @Provides
    @Singleton
    fun provideClient(retrofitService: RetrofitService): RetrofitClient {
        return RetrofitClient(retrofitService)
    }

}