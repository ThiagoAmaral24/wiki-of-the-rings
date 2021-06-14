package com.wotr.domain.dto

import com.squareup.moshi.Json

data class CharacterDto(
    val height: String,
    val race: String,
    val gender: String,
    val birth: String,
    val spouse: String,
    val realm: String,
    val hair: String,
    val name: String,
    val wikiUrl: String
)
