package com.example.ownnotes.ownNotesApp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ownnotes.R
import com.example.ownnotes.ownNotesDomain.model.Note

class NoteAdapter (private val notesList: List<Note>) : RecyclerView.Adapter<NoteViewHolder> (){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return NoteViewHolder(layoutInflater.inflate(R.layout.item_note, parent, false))
    }

    override fun getItemCount(): Int {
        return notesList.size
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val item = notesList[position]
        holder.render(item)
    }

}