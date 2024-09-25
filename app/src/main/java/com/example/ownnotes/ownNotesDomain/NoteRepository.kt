package com.example.ownnotes.ownNotesDomain

import com.example.ownnotes.ownNotesDomain.model.Note
import kotlinx.coroutines.flow.Flow

interface NoteRepository {

    fun saveNote (title: String, description: String)

    fun getAllNotes () : Flow<List<Note>>

    fun deleteNote (noteId: Int)

    fun editNote(noteId: Int, title: String, description: String)
}