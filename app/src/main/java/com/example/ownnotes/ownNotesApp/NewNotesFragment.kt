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
import com.example.ownnotes.ownNotesDomain.model.ColorNote
import org.koin.androidx.viewmodel.ext.android.viewModel
import kotlin.coroutines.ContinuationInterceptor.Key.equals


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
        val randomButton = binding.randomButton
        val textField1 = binding.textField1
        val textField2 = binding.textField2
        val toolbar = requireActivity().findViewById<Toolbar>(R.id.toolbar)
        val radioGroup = binding.radioGroup
        var colorNote = ColorNote.YELLOW
        val divider = binding.divider
        val randomTitle = binding.textRandomNote

        toolbar.title = "Create a note"

        args.note?.let { note ->
            textField1.setText(note.title)
            textField2.setText(note.description)
            createButton.text = "EDIT NOTE"
            toolbar.title = "Edit a note"
        }

        if (args.random == "No"){
            randomButton.visibility= View.GONE
            divider.visibility= View.GONE
            randomTitle.visibility= View.GONE
        }

        val colorMap = mapOf(
            R.id.radio_option_yellow to ColorNote.YELLOW,
            R.id.radio_option_blue to ColorNote.BLUE,
            R.id.radio_option_green to ColorNote.GREEN,
            R.id.radio_option_red to ColorNote.RED
        )

        radioGroup.setOnCheckedChangeListener { group, checkedId ->
            colorNote = colorMap[checkedId] ?: ColorNote.YELLOW
        }


        createButton.setOnClickListener{
            Log.i("color", colorNote.toString())
            if (args.note == null) {
                notesViewModel.textFields(textField1.text.toString(), textField2.text.toString(), colorNote)
            } else {
                notesViewModel.editNote(args.note!!.id, textField1.text.toString(), textField2.text.toString(), colorNote)
            }
            findNavController().navigate(R.id.action_newNotesFragment_to_notesListFragment2)
        }

        randomButton.setOnClickListener{
            notesViewModel.getNetworkNotes()
            findNavController().navigate(R.id.action_newNotesFragment_to_notesListFragment2)
        }

    }

}