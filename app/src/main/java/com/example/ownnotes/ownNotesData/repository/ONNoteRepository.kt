package com.example.ownnotes.ownNotesData.repository

import com.example.ownnotes.ownNotesData.datasources.LocalNoteDataSource
import com.example.ownnotes.ownNotesDomain.NoteRepository

class ONNoteRepository(
    private val localNoteDataSource: LocalNoteDataSource
): NoteRepository {
    override fun saveNote(title: String, description: String) {
        localNoteDataSource.saveNote(title, description)
    }
}