package com.example.ownnotes.ownNotesApp.adapter

import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ownnotes.R
import com.example.ownnotes.databinding.ItemNoteBinding
import com.example.ownnotes.ownNotesDomain.model.Note

class NoteAdapter (private val notesList: List<Note>, private val onDeleteClickListener:(Note) -> Unit, private val onEditClickListener:(Note) -> Unit ) : RecyclerView.Adapter<NoteAdapter.NoteViewHolder> (){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return NoteViewHolder(layoutInflater.inflate(R.layout.item_note, parent, false))
    }

    override fun getItemCount(): Int {
        return notesList.size
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val item = notesList[position]
        holder.render(item, onDeleteClickListener, onEditClickListener)
    }

    class NoteViewHolder (view: View): RecyclerView.ViewHolder(view) {
        private val binding = ItemNoteBinding.bind(view)

        fun render (noteModel: Note, onDeleteClickListener:(Note) -> Unit, onEditClickListener:(Note) -> Unit) {
            binding.noteTitle.text = noteModel.title
            binding.noteDescriptionContent.text = noteModel.description
            binding.deleteIcon.setBackgroundColor(Color.parseColor(noteModel.color.toHex()))
            binding.deleteIcon.setOnClickListener{ onDeleteClickListener(noteModel)}
            binding.editIcon.setBackgroundColor(Color.parseColor(noteModel.color.toHex()))
            binding.editIcon.setOnClickListener{ onEditClickListener(noteModel)}
            binding.noteCard.setCardBackgroundColor(Color.parseColor(noteModel.color.toHex()))

        }
    }

}