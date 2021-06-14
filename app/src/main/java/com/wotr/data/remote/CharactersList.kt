package com.wotr.data.remote

import com.squareup.moshi.Json

data class CharactersList(
    @field:Json(name = "docs") val docs: List<Character>
)