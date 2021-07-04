package com.parthib.notes

import android.provider.ContactsContract
import androidx.lifecycle.LiveData

class NotesRepository(private val notedao: Notedao) {

    val allNotes: LiveData<List<Notes>> = notedao.getAllNotes()

    suspend fun insert(note: Notes){
        notedao.insert(note)
    }

    suspend fun delete(note: Notes){
        notedao.delete(note)
    }
}