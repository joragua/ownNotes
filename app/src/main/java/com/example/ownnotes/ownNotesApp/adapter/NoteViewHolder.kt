package com.example.ownnotes.ownNotesApp.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.ownnotes.databinding.ItemNoteBinding
import com.example.ownnotes.ownNotesDomain.model.Note

class NoteViewHolder (view: View): ViewHolder(view) {
    val binding = ItemNoteBinding.bind(view)

    fun render (noteModel: Note, onDeleteClickListener:(Note) -> Unit, onEditClickListener:(Note) -> Unit) {
        binding.noteTitle.text = noteModel.title
        binding.noteDescriptionContent.text = noteModel.description
        binding.deleteIcon.setOnClickListener{ onDeleteClickListener(noteModel)}
        binding.editIcon.setOnClickListener{ onEditClickListener(noteModel)}
    }
}