package com.example.ownnotes.ownNotesData

import androidx.room.Dao
import androidx.room.Insert

@Dao
interface NoteDAO {
    @Insert
    fun insertNote (title: String, description: String)
}