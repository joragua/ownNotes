package com.example.ownnotes.ownNotesApp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.ownnotes.databinding.FragmentNewNotesBinding
import com.example.ownnotes.ownNotesApp.viewModels.NotesViewModel

/**
 * A simple [Fragment] subclass.
 * Use the [NewNotesFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class NewNotesFragment : Fragment() {
    private val notesViewModel = NotesViewModel()
    private lateinit var binding: FragmentNewNotesBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //Binding
        binding = FragmentNewNotesBinding.inflate(layoutInflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val createButton = binding.createButton

        createButton.setOnClickListener{
            val textField1 = binding.textField1
            val textField2 = binding.textField2
            notesViewModel.textFields(textField1.text.toString(), textField2.text.toString())
        }

    }

}