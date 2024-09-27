package com.example.ownnotes.dependecyinjection


import com.example.ownnotes.ownNotesApp.viewModels.NotesViewModel
import com.example.ownnotes.ownNotesData.datasources.LocalNoteDataSource
import com.example.ownnotes.ownNotesData.datasources.RemoteNoteDataSource
import com.example.ownnotes.ownNotesData.datasources.implementation.ONLocalNoteDataSource
import com.example.ownnotes.ownNotesData.datasources.implementation.ONRemoteNoteDataSource
import com.example.ownnotes.ownNotesData.repository.ONNoteRepository
import com.example.ownnotes.ownNotesData.OwnNotesDatabase
import com.example.ownnotes.ownNotesDomain.NoteRepository
import com.example.ownnotes.ownNotesDomain.usecases.SaveNoteUseCase
import com.example.ownnotes.ownNotesDomain.usecases.GetAllNotesUseCase
import com.example.ownnotes.ownNotesDomain.usecases.DeleteNoteUseCase
import com.example.ownnotes.ownNotesDomain.usecases.EditNoteUseCase
import com.example.ownnotes.ownNotesDomain.usecases.GetRandomNotesUseCase
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val appModule = module {
    single { OwnNotesDatabase.getDatabase(androidContext()).noteDao()}
    singleOf(::ONLocalNoteDataSource) bind LocalNoteDataSource::class
    singleOf(::ONRemoteNoteDataSource) bind RemoteNoteDataSource::class
    factoryOf(::ONNoteRepository) bind NoteRepository::class
    factoryOf(::SaveNoteUseCase)
    factoryOf(::GetAllNotesUseCase)
    factoryOf(::DeleteNoteUseCase)
    factoryOf(::EditNoteUseCase)
    factoryOf(::GetRandomNotesUseCase)
    viewModel{NotesViewModel(get(), get(), get(), get(), get())}
}