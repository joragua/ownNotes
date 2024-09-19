package com.example.ownnotes.owNotesApp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import com.example.ownnotes.R
import com.example.ownnotes.owNotesApp.viewModels.NotesViewModel

/**
 * A simple [Fragment] subclass.
 * Use the [NewNotesFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class NewNotesFragment : Fragment() {
    private val notesViewModel = NotesViewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val root = inflater.inflate(R.layout.fragment_new_notes, container, false)

        val createButton = root.findViewById<Button>(R.id.createButton)

        createButton.setOnClickListener{
            val textFiled1 = root.findViewById<EditText>(R.id.textField1)
            val textFiled2 = root.findViewById<EditText>(R.id.textField2)
            notesViewModel.textFields(textFiled1.text.toString(), textFiled2.text.toString())
        }

        return root

    }

}