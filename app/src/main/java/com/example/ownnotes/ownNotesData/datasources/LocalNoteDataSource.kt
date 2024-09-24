package com.example.ownnotes.ownNotesData.datasources

interface LocalNoteDataSource {

    fun saveNote (title: String, description: String)
}