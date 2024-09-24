package com.example.ownnotes.ownNotesApp

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ownnotes.R
import com.example.ownnotes.databinding.FragmentFirstBinding
import com.example.ownnotes.databinding.FragmentNewNotesBinding
import com.example.ownnotes.ownNotesApp.adapter.NoteAdapter
import com.example.ownnotes.ownNotesDomain.model.Note

class NotesListFragment : Fragment() {
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
        val manager = LinearLayoutManager(requireContext())
        val recyclerView = binding.recyclerNotes
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = NoteAdapter(listOf(Note("hola", "q tal"), Note ("yo bien", "y tu")))
    }

}