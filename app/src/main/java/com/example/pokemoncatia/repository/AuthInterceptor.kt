package com.example.pokemoncatia.repository

import android.util.Log
import okhttp3.Interceptor
import retrofit2.Response


class AuthInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain?): okhttp3.Response {
        val requestBuilder = chain!!.request().newBuilder()
        requestBuilder.addHeader("Authorization", "Basic cG9rZWFwaTpwb2tlbW9u")
        val request = requestBuilder.build()
        val response = chain.proceed(request)
        if (response.code() == 401) {
            Log.e("MEUAPP", "Error API KEY")
        }
        return response
    }
}