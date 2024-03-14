package com.openclassrooms.notes

import com.openclassrooms.notes.data.LocalNotesApiService
import org.junit.Before
import org.junit.Test
import org.junit.Assert.assertEquals


class LocalNotesApiServiceTest {

    //declaration de la variable du service à tester
    private lateinit var localNotesApiService: LocalNotesApiService

    @Before
    fun setUp() {
        //init de LocalNotesApiService avant chaque test
        localNotesApiService = LocalNotesApiService()
    }

    @Test
    fun getAllNotes() {

        val result = localNotesApiService.getAllNotes()//execution de la méthode à tester

        assert(result.isNotEmpty())//verif que le résultat n'est pas vide

        //verif que le résultat contient un élément spécifique cad title de la première note
        assertEquals("Test result failure", result.first().title, "La vie est belle")

    }
}