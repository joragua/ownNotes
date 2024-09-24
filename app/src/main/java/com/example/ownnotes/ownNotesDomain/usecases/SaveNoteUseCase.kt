package com.example.ownnotes.ownNotesDomain.usecases

import com.example.ownnotes.ownNotesDomain.NoteRepository

class SaveNoteUseCase(
    private val noteRepository: NoteRepository
) {
    fun run (title: String, description: String){
        noteRepository.saveNote(title, description)
    }
}