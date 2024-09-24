package com.example.ownnotes.ownNotesDomain.usecases

import com.example.ownnotes.ownNotesDomain.NoteRepository
import com.example.ownnotes.ownNotesDomain.model.Note
import kotlinx.coroutines.flow.Flow

class GetAllNotesUseCase(
    private val noteRepository: NoteRepository
) {
    fun run () : Flow<List<Note>> {
        return noteRepository.getAllNotes()
    }
}