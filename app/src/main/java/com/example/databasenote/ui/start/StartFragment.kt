package com.example.databasenote.ui.start

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.databasenote.APP
import com.example.databasenote.R
import com.example.databasenote.adapter.NoteAdapter
import com.example.databasenote.databinding.FragmentStartBinding
import com.example.databasenote.model.NoteModel

class StartFragment : Fragment() {
    lateinit var binding: FragmentStartBinding
    lateinit var recyclerView: RecyclerView
    lateinit var noteAdapter: NoteAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentStartBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        init()
    }

    private fun init() {
        val viewModel = ViewModelProvider(this).get((StartViewModel::class.java))
        viewModel.initDatabase()
        recyclerView = binding.rvNotes
        noteAdapter = NoteAdapter()
            recyclerView.adapter = noteAdapter
            viewModel.getAllNotes().observe(viewLifecycleOwner) { listNotes ->
                noteAdapter.update(listNotes.asReversed())
            }

            binding.btnNext.setOnClickListener {
                APP.navController.navigate(R.id.action_startFragment_to_addNoteFragment)
            }


    }
    companion object{
        fun clickNote(noteModel: NoteModel){
           val bundle = Bundle()
            bundle.putSerializable("note",noteModel)
            APP.navController.navigate(R.id.action_startFragment_to_detailFragment,bundle)
        }
    }


}