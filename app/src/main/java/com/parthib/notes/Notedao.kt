package com.parthib.notes

import android.provider.ContactsContract
import androidx.lifecycle.LiveData
import androidx.room.*


@Dao
interface Notedao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    //suspend is a coroutines which makes background process easier.
    suspend fun insert(note:Notes)

    @Delete
    suspend fun delete(note: Notes)

    @Query(value = "Select * from notes_table order by id ASC")
    fun getAllNotes(): LiveData<List<Notes>>

}