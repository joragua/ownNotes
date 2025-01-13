package com.example.ownnotes.ownNotesData.datasources

import com.example.ownnotes.ownNotesDomain.model.RandomNote

interface RemoteNoteDataSource {

    suspend fun getRandomNotes() : RandomNote?
}