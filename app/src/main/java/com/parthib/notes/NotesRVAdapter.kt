package com.parthib.notes


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NotesRVAdapter(private val context: Context, private val listener:INotesRVAdapter) : RecyclerView.Adapter<NotesRVAdapter.NotesViewHolder>() {

     private val allNotes= ArrayList<Notes>()

    inner class NotesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val textView:TextView = itemView.findViewById(R.id.text)
        val deleteButton:ImageView= itemView.findViewById(R.id.deleteButton)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotesViewHolder {
       val viewHolder=NotesViewHolder(LayoutInflater.from(context).inflate(R.layout.item_note, parent,false))
        viewHolder.deleteButton.setOnClickListener{
            listener.onItemClicked(allNotes[viewHolder.adapterPosition])
        }
        return viewHolder
    }

    override fun onBindViewHolder(holder: NotesViewHolder, position: Int) {
        val currentNote=allNotes[position]
        holder.textView.text=currentNote.text
    }

    override fun getItemCount(): Int {
       return allNotes.size
    }

    fun updateList(newList: List<Notes>){
        allNotes.clear()
        allNotes.addAll(newList)

        notifyDataSetChanged()
    }
}

interface INotesRVAdapter {
    fun onItemClicked(note: Notes)
}