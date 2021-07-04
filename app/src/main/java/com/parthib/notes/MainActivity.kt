package com.parthib.notes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(), INotesRVAdapter {

    lateinit var viewModel: NoteViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rec:RecyclerView=findViewById(R.id.recylerView)
        rec.layoutManager=LinearLayoutManager(this)
        val adapter =  NotesRVAdapter(this,this)
        rec.adapter=adapter

        viewModel=ViewModelProvider(this,ViewModelProvider.AndroidViewModelFactory.getInstance(application)).get(NoteViewModel::class.java)
        viewModel.allNotes.observe(this, Observer {list->
            list?.let {
                adapter.updateList(it)
            }

        })


    }

    override fun onItemClicked(note: Notes) {
        viewModel.deleteNote(note)
        Toast.makeText(this,"${note.text} Deleted", Toast.LENGTH_LONG).show()
    }

    fun submitData(view: View) {
        val input: TextView = findViewById(R.id.input)
        val noteText = input.text.toString()
        if (noteText.isNotEmpty()){
            viewModel.insertNote(Notes(noteText))
            Toast.makeText(this,"$noteText Inserted", Toast.LENGTH_LONG).show()
        }
        else{
            Toast.makeText(this,"Enter the note!", Toast.LENGTH_SHORT).show()
        }
    }
}