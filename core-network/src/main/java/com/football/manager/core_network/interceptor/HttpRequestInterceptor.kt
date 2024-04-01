package com.football.manager.core_network.interceptor

import com.football.manager.core_network.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response
import timber.log.Timber

internal class HttpRequestInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        originalRequest.newBuilder()
            .build()
        Timber.e(originalRequest.toString())
        return chain.proceed(originalRequest)
    }

}
