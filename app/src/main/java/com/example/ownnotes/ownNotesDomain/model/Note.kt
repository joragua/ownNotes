package com.example.ownnotes.ownNotesDomain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Note(
    val id: Int,
    val title: String,
    val description: String,
    val color: ColorNote
) : Parcelable