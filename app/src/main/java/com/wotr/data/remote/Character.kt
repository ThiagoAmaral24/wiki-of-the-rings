package com.wotr.data.remote

import com.squareup.moshi.Json

data class Character(
    @field:Json(name = "height") val height: String,
    @field:Json(name = "race") val race: String,
    @field:Json(name = "gender") val gender: String,
    @field:Json(name = "birth") val birth: String,
    @field:Json(name = "spouse") val spouse: String,
    @field:Json(name = "realm") val realm: String,
    @field:Json(name = "hair") val hair: String,
    @field:Json(name = "name") val name: String,
    @field:Json(name = "wikiUrl") val wikiUrl: String
)