package com.parthib.notes

import android.provider.ContactsContract
import androidx.room.*


@Dao
interface Notedao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(note:Notes)

    @Delete
    fun delete(note: Notes)

    @Query(value = "Select * from notes_table order by id ASC")
    fun getAllNotes(): List<Notes>

}