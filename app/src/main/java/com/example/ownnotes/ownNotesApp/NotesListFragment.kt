package com.example.ownnotes.ownNotesApp

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ownnotes.R
import com.example.ownnotes.databinding.FragmentFirstBinding
import com.example.ownnotes.databinding.FragmentNewNotesBinding
import com.example.ownnotes.databinding.ItemNoteBinding
import com.example.ownnotes.ownNotesApp.adapter.NoteAdapter
import com.example.ownnotes.ownNotesApp.viewModels.NotesViewModel
import com.example.ownnotes.ownNotesDomain.model.Note
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class NotesListFragment : Fragment() {
    private val notesViewModel by viewModel<NotesViewModel>()
    private lateinit var binding: FragmentFirstBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFirstBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recyclerView = binding.recyclerNotes
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        viewLifecycleOwner.lifecycleScope.launch {
            notesViewModel.notesList.collect { notesList ->
                recyclerView.adapter = NoteAdapter(notesList, { note -> deleteNote(note) }, { note -> editNote(note) })
            }
        }
    }

    fun deleteNote(note: Note){
        notesViewModel.deleteNote(note.id)
    }

    fun editNote(note:Note){
        findNavController().navigate(NotesListFragmentDirections.actionNotesListFragmentToNewNotesFragment(note))
    }



}