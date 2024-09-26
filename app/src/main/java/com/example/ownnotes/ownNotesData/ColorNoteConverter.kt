package com.example.ownnotes.ownNotesData

import androidx.room.TypeConverter
import com.example.ownnotes.ownNotesDomain.model.ColorNote

class ColorNoteConverter {

    @TypeConverter
    fun fromColorNote (color: ColorNote): String {
        return color.name
    }

    @TypeConverter
    fun toColorNote (color: String): ColorNote {
        return ColorNote.valueOf(color)
    }
}