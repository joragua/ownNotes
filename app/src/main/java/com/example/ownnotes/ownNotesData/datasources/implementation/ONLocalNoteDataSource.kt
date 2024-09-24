package com.example.ownnotes.ownNotesData.datasources.implementation

import com.example.ownnotes.ownNotesData.NoteDAO
import com.example.ownnotes.ownNotesData.NoteEntity
import com.example.ownnotes.ownNotesData.datasources.LocalNoteDataSource

class ONLocalNoteDataSource (
    private val noteDao: NoteDAO
) : LocalNoteDataSource {
    override fun saveNote(title: String, description: String) {
        val noteEntity = NoteEntity (0, title, description)
        noteDao.insertNote(noteEntity)
    }

}