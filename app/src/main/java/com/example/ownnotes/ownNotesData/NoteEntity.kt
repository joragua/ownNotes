package com.example.ownnotes.ownNotesData

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.ownnotes.ownNotesDomain.model.ColorNote

@Entity (tableName = "notes")
data class NoteEntity (
    @PrimaryKey(autoGenerate = true) val id: Int,
    val title: String,
    val description: String,
    val color: ColorNote
)