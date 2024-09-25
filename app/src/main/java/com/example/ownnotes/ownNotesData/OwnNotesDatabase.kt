package com.example.ownnotes.ownNotesData

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database (entities = [NoteEntity::class], version = 1, exportSchema = false)
abstract class ownNotesDatabase: RoomDatabase() {

    abstract fun noteDao(): NoteDAO
    
    companion object {
        @Volatile
        private var INSTANCE: ownNotesDatabase? = null
        fun getDatabase(context: Context): ownNotesDatabase{
            return INSTANCE ?: synchronized(this){
                val instance = Room.databaseBuilder(context.applicationContext, ownNotesDatabase::class.java, "notes_database").build()
                INSTANCE = instance
                instance
            }
        }
    }
}
