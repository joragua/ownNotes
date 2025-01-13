package com.example.ownnotes.ownNotesData.datasources.implementation

import android.util.Log
import com.example.ownnotes.ownNotesComLibrary.MarsApi
import com.example.ownnotes.ownNotesData.datasources.RemoteNoteDataSource
import com.example.ownnotes.ownNotesDomain.model.RandomNote
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory

class ONRemoteNoteDataSource: RemoteNoteDataSource {

    override suspend fun getRandomNotes(): RandomNote? {
        val listResultJson = MarsApi.retrofitService.getRandomNotes()
        val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
        val type = Types.newParameterizedType(List::class.java, RandomNote::class.java)
        val jsonAdapter = moshi.adapter<List<RandomNote>>(type)
        val listResult = jsonAdapter.fromJson(listResultJson)
        return listResult?.random()
    }
}