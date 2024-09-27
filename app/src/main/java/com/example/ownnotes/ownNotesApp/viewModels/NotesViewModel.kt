package com.example.ownnotes.ownNotesApp.viewModels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ownnotes.ownNotesComLibrary.MarsApi
import com.example.ownnotes.ownNotesDomain.model.ColorNote
import com.example.ownnotes.ownNotesDomain.model.Note
import com.example.ownnotes.ownNotesDomain.model.RandomNote
import com.example.ownnotes.ownNotesDomain.usecases.DeleteNoteUseCase
import com.example.ownnotes.ownNotesDomain.usecases.EditNoteUseCase
import com.example.ownnotes.ownNotesDomain.usecases.GetAllNotesUseCase
import com.example.ownnotes.ownNotesDomain.usecases.GetRandomNotesUseCase
import com.example.ownnotes.ownNotesDomain.usecases.SaveNoteUseCase
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import com.squareup.moshi.adapter
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import java.util.Random

class NotesViewModel (
    private val saveNoteUseCase: SaveNoteUseCase,
    private val getAllNotesUseCase: GetAllNotesUseCase,
    private val deleteNoteUseCase: DeleteNoteUseCase,
    private val editNoteUseCase: EditNoteUseCase,
    private val getRandomNotesUseCase: GetRandomNotesUseCase
): ViewModel(){

    val notesList: Flow<List<Note>> = getAllNotes()

    fun textFields (argument1: String, argument2: String, color: ColorNote) {
        viewModelScope.launch (Dispatchers.IO) {
            saveNoteUseCase.run(argument1, argument2, color)
        }
    }

    private fun getAllNotes () : Flow<List<Note>> {
        return getAllNotesUseCase.run()
    }

    fun deleteNote(note: Note) {
        viewModelScope.launch (Dispatchers.IO) {
            deleteNoteUseCase.run(note)
        }

    }

    fun editNote(id: Int, title: String, description: String, color: ColorNote) {
        viewModelScope.launch (Dispatchers.IO) {
            editNoteUseCase.run(id, title, description, color)
        }
    }

    fun getNetworkNotes(){
        viewModelScope.launch (Dispatchers.IO) {
            val randomNote = getRandomNotesUseCase.run()
            if (randomNote != null) {
                saveNoteUseCase.run("Random note #${randomNote.id}", randomNote.imgSrc, ColorNote.YELLOW)
            }
        }
    }


}