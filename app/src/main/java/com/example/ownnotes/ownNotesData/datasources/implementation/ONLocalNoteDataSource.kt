package com.example.ownnotes.ownNotesData.datasources.implementation

import com.example.ownnotes.ownNotesData.NoteDAO
import com.example.ownnotes.ownNotesData.NoteEntity
import com.example.ownnotes.ownNotesData.datasources.LocalNoteDataSource
import com.example.ownnotes.ownNotesDomain.model.ColorNote
import com.example.ownnotes.ownNotesDomain.model.Note
import kotlinx.coroutines.flow.Flow

class ONLocalNoteDataSource (
    private val noteDao: NoteDAO
) : LocalNoteDataSource {
    override fun saveNote(title: String, description: String, color: ColorNote) {
        val noteEntity = NoteEntity (0, title, description, color)
        noteDao.insertNote(noteEntity)
    }

    override fun getAllNotes() : Flow<List<Note>> {
        return noteDao.getAllNotes()
    }

    override fun deleteNote(note: Note){
        val noteEntity = NoteEntity(note.id, note.title, note.description, note.color)
        noteDao.deleteNote(noteEntity)
    }

    override fun editNote(id: Int, title: String, description: String, color: ColorNote ){
        val noteEntity = NoteEntity (id, title, description, color)
        noteDao.upsertNote(noteEntity)
    }

}