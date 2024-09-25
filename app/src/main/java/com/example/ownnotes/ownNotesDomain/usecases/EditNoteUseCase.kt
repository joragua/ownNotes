package com.example.ownnotes.ownNotesDomain.usecases

import com.example.ownnotes.ownNotesDomain.NoteRepository
import com.example.ownnotes.ownNotesDomain.model.Note
import kotlinx.coroutines.flow.Flow

class EditNoteUseCase(
    private val noteRepository: NoteRepository
) {
    fun run (noteId: Int, title: String, description: String) {
        noteRepository.editNote(noteId, title, description)
    }
}