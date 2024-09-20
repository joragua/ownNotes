package com.example.ownnotes.ownNotesDomain

interface NoteRepository {

    fun saveNote (title: String, description: String)
}