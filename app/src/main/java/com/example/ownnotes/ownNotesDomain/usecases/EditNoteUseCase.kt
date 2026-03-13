package com.example.ownnotes.ownNotesDomain.usecases

import com.example.ownnotes.ownNotesDomain.NoteRepository
import com.example.ownnotes.ownNotesDomain.model.ColorNote

class EditNoteUseCase(
    private val noteRepository: NoteRepository
) {
    fun run (noteId: Int, title: String, description: String, color: ColorNote) {
        noteRepository.editNote(noteId, title, description, color)
    }
}
