package com.football.manager.core_network.interceptor

import okhttp3.Interceptor
import okhttp3.Response
import timber.log.Timber

internal class HttpRequestInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        originalRequest.run {
            newBuilder().apply {
                header("", "")
                header("", "")
                url(originalRequest.url).build()
            }
        }
        Timber.e(originalRequest.toString())
        return chain.proceed(originalRequest)
    }

}
