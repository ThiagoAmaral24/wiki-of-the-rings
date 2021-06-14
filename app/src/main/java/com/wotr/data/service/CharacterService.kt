package com.wotr.data.service

import com.wotr.data.remote.CharactersList
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

interface CharacterService {

    @Headers("Authorization: Bearer $API_KEY_VALUE")
    @GET(WS_GET_LIST)
    suspend fun getList(): CharactersList

//    @GET(WS_GET_LIST_TYPES)
//    suspend fun getListTypes(
//        @Query(PARAM_API_KEY) apiKey: String = API_KEY_VALUE
//    ): ListTypeResult
//
//    @GET(WS_GET_REVIEWS)
//    suspend fun getReviews(
//        @Query(PARAM_TITLE) title: String,
//        @Query(PARAM_API_KEY) apiKey: String = API_KEY_VALUE
//    ): ReviewResult

}