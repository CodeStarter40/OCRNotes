package com.openclassrooms.notes.di

import com.openclassrooms.notes.data.LocalNotesApiService
import com.openclassrooms.notes.service.NotesApiService
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideNotesApiService(): NotesApiService = LocalNotesApiService()
}