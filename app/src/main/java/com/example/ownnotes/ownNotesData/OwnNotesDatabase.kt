package com.example.ownnotes.ownNotesData

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters


@Database (entities = [NoteEntity::class], version = 1, exportSchema = true)
@TypeConverters(ColorNoteConverter::class)
abstract class OwnNotesDatabase: RoomDatabase() {

    abstract fun noteDao(): NoteDAO

    companion object {
        @Volatile
        private var INSTANCE: OwnNotesDatabase? = null
        fun getDatabase(context: Context): OwnNotesDatabase {
            return INSTANCE ?: synchronized(this){
                val instance = Room.databaseBuilder(context.applicationContext, OwnNotesDatabase::class.java, "notes_database_2").build()
                INSTANCE = instance
                instance
            }
        }
    }
}