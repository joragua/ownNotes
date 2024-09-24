package com.example.ownnotes.ownNotesData.repository

import com.example.ownnotes.ownNotesData.datasources.LocalNoteDataSource
import com.example.ownnotes.ownNotesDomain.NoteRepository
import com.example.ownnotes.ownNotesDomain.model.Note
import kotlinx.coroutines.flow.Flow

class ONNoteRepository(
    private val localNoteDataSource: LocalNoteDataSource
): NoteRepository {
    override fun saveNote(title: String, description: String) {
        localNoteDataSource.saveNote(title, description)
    }

    override fun getAllNotes(): Flow<List<Note>> {
        return localNoteDataSource.getAllNotes()
    }

    override fun deleteNote(noteId: Int){
        localNoteDataSource.deleteNote(noteId)
    }

}