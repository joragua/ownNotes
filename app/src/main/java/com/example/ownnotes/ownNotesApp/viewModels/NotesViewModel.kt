package com.example.ownnotes.ownNotesApp.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ownnotes.ownNotesDomain.usecases.SaveNoteUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NotesViewModel (
    private val saveNoteUseCase: SaveNoteUseCase
): ViewModel(){

    fun  textFields (argument1: String, argument2: String) {
        viewModelScope.launch (Dispatchers.IO) {
            saveNoteUseCase.run(argument1, argument2)
        }
    }
}