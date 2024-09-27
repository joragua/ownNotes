package com.example.ownnotes.ownNotesDomain.usecases

import com.example.ownnotes.ownNotesDomain.NoteRepository
import com.example.ownnotes.ownNotesDomain.model.RandomNote

class GetRandomNotesUseCase(
    private val noteRepository: NoteRepository
) {
    suspend fun run (): RandomNote? {
        return noteRepository.getRandomNotes()
    }
}