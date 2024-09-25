package com.example.ownnotes.ownNotesApp

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.ownnotes.R
import com.example.ownnotes.databinding.FragmentNewNotesBinding
import com.example.ownnotes.ownNotesApp.viewModels.NotesViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import kotlin.coroutines.ContinuationInterceptor.Key.equals

/**
 * A simple [Fragment] subclass.
 * Use the [NewNotesFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class NewNotesFragment : Fragment() {
    private val notesViewModel by viewModel<NotesViewModel>()
    private lateinit var binding: FragmentNewNotesBinding

    val args: NewNotesFragmentArgs by navArgs()

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
        val textField1 = binding.textField1
        val textField2 = binding.textField2

        val toolbar = requireActivity().findViewById<Toolbar>(R.id.toolbar)
        toolbar.title = "Create a note"

        args.note?.let { note ->
            textField1.setText(note.title)
            textField2.setText(note.description)
            createButton.text = "EDIT NOTE"
            toolbar.title = "Edit a note"
        }

        createButton.setOnClickListener{
            if (args.note == null) {
                notesViewModel.textFields(textField1.text.toString(), textField2.text.toString())
            } else {
                notesViewModel.editNote(args.note!!.id, textField1.text.toString(), textField2.text.toString())
            }
            findNavController().navigate(R.id.action_newNotesFragment_to_notesListFragment2)
        }

    }

}