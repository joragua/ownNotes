package com.example.ownnotes.ownNotesData.datasources.implementation

import com.example.ownnotes.ownNotesData.NoteDAO
import com.example.ownnotes.ownNotesData.NoteEntity
import com.example.ownnotes.ownNotesData.datasources.LocalNoteDataSource
import com.example.ownnotes.ownNotesDomain.model.Note
import kotlinx.coroutines.flow.Flow

class ONLocalNoteDataSource (
    private val noteDao: NoteDAO
) : LocalNoteDataSource {
    override fun saveNote(title: String, description: String) {
        val noteEntity = NoteEntity (0, title, description)
        noteDao.insertNote(noteEntity)
    }

    override fun getAllNotes() : Flow<List<Note>> {
        return noteDao.getAllNotes()
    }

    override fun deleteNote(noteId: Int){
        noteDao.deleteNote(noteId)
    }

}