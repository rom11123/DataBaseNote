package com.example.databasenote.ui.start

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.databasenote.REPOSITORY
import com.example.databasenote.data_base.NoteDataBase
import com.example.databasenote.data_base.repository.NoteRealization
import com.example.databasenote.model.NoteModel

class StartViewModel(application: Application):AndroidViewModel(application) {

    private val context = application

    fun initDatabase(){
        val daoNote = NoteDataBase.getInstance(context).getNoteDao()
        REPOSITORY = NoteRealization(daoNote)
    }
    fun getAllNotes():LiveData<List<NoteModel>>{
        return REPOSITORY.allNotes
    }
}