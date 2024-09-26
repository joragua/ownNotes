package com.example.ownnotes.ownNotesDomain.usecases

import com.example.ownnotes.ownNotesDomain.NoteRepository
import com.example.ownnotes.ownNotesDomain.model.Note

class DeleteNoteUseCase(
    private val noteRepository: NoteRepository
) {
    fun run (note: Note) {
       noteRepository.deleteNote(note)
    }
}