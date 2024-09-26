package com.example.ownnotes.ownNotesApp

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.Toolbar

import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ownnotes.R
import com.example.ownnotes.databinding.FragmentFirstBinding
import com.example.ownnotes.ownNotesApp.adapter.NoteAdapter
import com.example.ownnotes.ownNotesApp.viewModels.NotesViewModel
import com.example.ownnotes.ownNotesDomain.model.Note
import com.google.android.material.snackbar.Snackbar
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

        val toolbar = requireActivity().findViewById<Toolbar>(R.id.toolbar)
        toolbar.title = "ownNotes"


        val recyclerView = binding.recyclerNotes
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        viewLifecycleOwner.lifecycleScope.launch {
            notesViewModel.notesList.collect { notesList ->
                recyclerView.adapter = NoteAdapter(notesList, { note -> deleteNote(note) }, { note -> editNote(note) })
            }
        }

        binding.fab.setOnClickListener { view ->
            findNavController().navigate(NotesListFragmentDirections.actionNotesListFragmentToNewNotesFragment(null))
            view.visibility = View.GONE
        }
    }

    private fun deleteNote(note: Note){
        val builder = AlertDialog.Builder(requireContext())
        builder.setTitle("Confirmation")
        builder.setMessage("Do you want to delete the note with title: ${note.title}?")

        builder.setPositiveButton("Delete") { dialog, _ ->
            notesViewModel.deleteNote(note)
            dialog.dismiss()
            showUndoSnackbar(view, note)
        }

        builder.setNegativeButton("Cancel") { dialog, _ ->
            dialog.dismiss()
        }

        builder.create().show()
    }

    private fun editNote(note:Note){
        findNavController().navigate(NotesListFragmentDirections.actionNotesListFragmentToNewNotesFragment(note))
    }

    private fun showUndoSnackbar(view: View?, note: Note) {
        view?.let {
            Snackbar.make(it, "Note removed", Snackbar.LENGTH_LONG)
                .setAction("Undo") {
                    notesViewModel.editNote(note.id, note.title, note.description)
                }
        }?.show()
    }



}