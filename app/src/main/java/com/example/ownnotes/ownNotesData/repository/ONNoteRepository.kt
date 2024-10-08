package com.example.ownnotes.ownNotesData.repository

import com.example.ownnotes.ownNotesData.datasources.LocalNoteDataSource
import com.example.ownnotes.ownNotesDomain.NoteRepository
import com.example.ownnotes.ownNotesDomain.model.ColorNote
import com.example.ownnotes.ownNotesDomain.model.Note
import kotlinx.coroutines.flow.Flow

class ONNoteRepository(
    private val localNoteDataSource: LocalNoteDataSource
): NoteRepository {
    override fun saveNote(title: String, description: String, color: ColorNote) {
        localNoteDataSource.saveNote(title, description, color)
    }

    override fun getAllNotes(): Flow<List<Note>> {
        return localNoteDataSource.getAllNotes()
    }

    override fun deleteNote(note: Note){
        localNoteDataSource.deleteNote(note)
    }

    override fun editNote(noteId: Int, title: String, description: String, color: ColorNote){
        localNoteDataSource.editNote(noteId, title, description, color)
    }

}