package com.example.databasenote.ui.add_notes

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.databasenote.REPOSITORY
import com.example.databasenote.model.NoteModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AddNoteViewModel:ViewModel() {
    fun insert(noteModel: NoteModel,onSuccess:()->Unit)=
        viewModelScope.launch (Dispatchers.IO){
            REPOSITORY.insertNote(noteModel){
                onSuccess()
            }

        }
}