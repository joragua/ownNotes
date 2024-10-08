package com.example.ownnotes.ownNotesData

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Upsert
import com.example.ownnotes.ownNotesDomain.model.Note
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDAO {

    @Insert
    fun insertNote (noteEntity: NoteEntity)

    @Query("SELECT * FROM notes")
    fun getAllNotes(): Flow<List<Note>>

     @Delete
     fun deleteNote(noteEntity: NoteEntity)

     @Upsert
     fun upsertNote(noteEntity: NoteEntity)
}