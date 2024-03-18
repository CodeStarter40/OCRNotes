package com.openclassrooms.notes

import com.openclassrooms.notes.model.Note
import com.openclassrooms.notes.repository.NotesRepository
import com.openclassrooms.notes.service.NotesApiService
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.`when`

class NotesRepositoryTest {

    private lateinit var notesApiService: NotesApiService
    private lateinit var notesRepository: NotesRepository

    @Before
    fun setUp() {
        //mock NotesApiService
        notesApiService = mock(NotesApiService::class.java)
        //init du repo avec le service mocké
        notesRepository = NotesRepository(notesApiService)
    }

    @Test
    fun `back_Note_Success`() = runBlockingTest {
        //given prepa du test
        val expectedNotes = listOf(
            Note("Note 1", "Body 1"),
            Note("Note 2", "Body 2")
        )
        `when`(notesApiService.getAllNotes()).thenReturn(expectedNotes)

        //when exec code à tester, demande au repo mocké de nous fournir les notes
        val result = notesRepository.notes.first()
        //then verif des notes prépa dans le given
        assertEquals(expectedNotes, result)
    }
}