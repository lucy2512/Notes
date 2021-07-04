package com.parthib.notes

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData

class NoteViewModel(application: Application) : AndroidViewModel(application) {

    val allNotes: LiveData<List<Notes>>

    init{
        val dao =NoteDatabase.getDatabase(application).getNotedao()
        val repository = NotesRepository(dao)
        allNotes = repository.allNotes
    }
}