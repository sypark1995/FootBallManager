package com.football.manager.core_network.di

import com.football.manager.core_network.adapter.ResultCallAdapterFactory
import com.football.manager.core_network.interceptor.HttpRequestInterceptor
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
            .baseUrl("")
            .addConverterFactory(MoshiConverterFactory.create())
            .addCallAdapterFactory(ResultCallAdapterFactory())
            .build()
    }

//    @Provides
//    @Singleton
//    fun provideService(retrofit: Retrofit): RetrofitService {
//        return retrofit.create(RetrofitService::class.java)
//    }
//
//    @Provides
//    @Singleton
//    fun provideClient(retrofitService: RetrofitService): RetrofitClient {
//        return RetrofitClient(retrofitService)
//    }

}