package com.openclassrooms.notes.repository

import com.openclassrooms.notes.data.LocalNotesApiService
import com.openclassrooms.notes.service.NotesApiService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import com.openclassrooms.notes.model.Note
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Repository class for the notes.
 */
@Singleton
class NotesRepository @Inject constructor(notesApiService: NotesApiService) {

    /**
     * The API service for interacting with notes.
     */
    private val notesApiService: NotesApiService = LocalNotesApiService()

    /**
     * A flow that emits a list of all notes.
     */
    val notes: Flow<List<Note>> = flow {
        emit(notesApiService.getAllNotes())
    }


}