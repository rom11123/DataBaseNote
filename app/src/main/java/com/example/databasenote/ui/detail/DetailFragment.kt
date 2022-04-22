package com.example.databasenote.ui.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.databasenote.APP
import com.example.databasenote.R
import com.example.databasenote.databinding.FragmentDetailBinding
import com.example.databasenote.model.NoteModel

class DetailFragment : Fragment() {
    lateinit var binding: FragmentDetailBinding
    lateinit var noteModel: NoteModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentDetailBinding.inflate(layoutInflater, container, false)
        noteModel = arguments?.getSerializable("note") as NoteModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        val viewModel = ViewModelProvider(this).get(DetailViewModel::class.java)

        binding.tvTitleDetail.text = noteModel.title
        binding.tvDescriptionDetail.text = noteModel.description
        binding.btnDelete.setOnClickListener {
            viewModel.delete(noteModel) {}
            APP.navController.navigate(R.id.action_detailFragment_to_startFragment)
        }
        binding.btnBack.setOnClickListener {
            APP.navController.navigate(R.id.action_detailFragment_to_startFragment)
        }

    }

}