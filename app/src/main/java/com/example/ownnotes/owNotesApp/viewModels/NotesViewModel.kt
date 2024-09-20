package com.example.ownnotes.owNotesApp.viewModels

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.ownnotes.ownNotesDomain.usecases.SaveNoteUseCase

class NotesViewModel (
    private val saveNoteUseCase: SaveNoteUseCase
): ViewModel(){

    fun  textFields (argument1: String, argument2: String) {
        saveNoteUseCase.run(argument1, argument2)
    }
}