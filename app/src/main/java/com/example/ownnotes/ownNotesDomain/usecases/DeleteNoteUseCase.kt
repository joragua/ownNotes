package com.example.ownnotes.ownNotesDomain.usecases

import com.example.ownnotes.ownNotesDomain.NoteRepository

class DeleteNoteUseCase(
    private val noteRepository: NoteRepository
) {
    fun run (noteId: Int) {
       noteRepository.deleteNote(noteId)
    }
}