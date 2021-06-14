package com.wotr.data.service.factory

import com.wotr.data.service.CharacterService
import com.wotr.data.service.URL_BASE
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object CharacterServiceFactory {

    private val httpClient = OkHttpClient.Builder()
        .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
        .build()

    private val retrofit = Retrofit.Builder()
        .baseUrl(URL_BASE)
        .client(httpClient)
        .addConverterFactory(MoshiConverterFactory.create())
        .build()

    fun getService() = retrofit.create(CharacterService::class.java)

}