package com.example.ownnotes.ownNotesDomain.usecases

import com.example.ownnotes.ownNotesDomain.NoteRepository
import com.example.ownnotes.ownNotesDomain.model.ColorNote

class SaveNoteUseCase(
    private val noteRepository: NoteRepository
) {
    fun run (title: String, description: String, color: ColorNote){
        noteRepository.saveNote(title, description, color)
    }
}