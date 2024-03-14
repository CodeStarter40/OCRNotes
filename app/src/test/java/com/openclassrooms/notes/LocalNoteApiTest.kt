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
        assertEquals("Test title failure", result.first().title, "La vie est belle")
        assertEquals("test body failure", result.first().body,"La vie est belle, pleine de choses à voir et à faire. Profitez de chaque moment et ne laissez jamais personne vous dire que vous ne pouvez pas faire ce que vous voulez.")

    }
}