package com.example.ownnotes.ownNotesDomain.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass


@JsonClass(generateAdapter = true)
data class RandomNote(
    val id: String,

    @Json(name = "img_src")
    val imgSrc: String
)