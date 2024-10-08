package com.example.ownnotes.ownNotesData.datasources

import com.example.ownnotes.ownNotesDomain.model.ColorNote
import com.example.ownnotes.ownNotesDomain.model.Note
import kotlinx.coroutines.flow.Flow

interface LocalNoteDataSource {

    fun saveNote (title: String, description: String, color: ColorNote)

    fun getAllNotes() : Flow<List<Note>>

    fun deleteNote(note: Note)

    fun editNote(noteId: Int, title: String, description: String, color: ColorNote)
}