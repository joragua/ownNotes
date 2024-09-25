package com.example.ownnotes.ownNotesApp.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ownnotes.ownNotesDomain.model.Note
import com.example.ownnotes.ownNotesDomain.usecases.DeleteNoteUseCase
import com.example.ownnotes.ownNotesDomain.usecases.EditNoteUseCase
import com.example.ownnotes.ownNotesDomain.usecases.GetAllNotesUseCase
import com.example.ownnotes.ownNotesDomain.usecases.SaveNoteUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class NotesViewModel (
    private val saveNoteUseCase: SaveNoteUseCase,
    private val getAllNotesUseCase: GetAllNotesUseCase,
    private val deleteNoteUseCase: DeleteNoteUseCase,
    private val editNoteUseCase: EditNoteUseCase
): ViewModel(){

    val notesList: Flow<List<Note>> = getAllNotes()

    fun textFields (argument1: String, argument2: String) {
        viewModelScope.launch (Dispatchers.IO) {
            saveNoteUseCase.run(argument1, argument2)
        }
    }

    private fun getAllNotes () : Flow<List<Note>> {
        return getAllNotesUseCase.run()
    }

    fun deleteNote(noteId: Int) {
        viewModelScope.launch (Dispatchers.IO) {
            deleteNoteUseCase.run(noteId)
        }

    }

    fun editNote(id: Int, title: String, description: String) {
        viewModelScope.launch (Dispatchers.IO) {
            editNoteUseCase.run(id, title, description)
        }
    }


}