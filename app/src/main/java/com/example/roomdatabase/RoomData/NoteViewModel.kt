package com.example.roomdatabase.RoomData

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NoteViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: NoteRepository

    init {
    val dao = NoteDatabase.getDatabase(application).getNoteDAO()
    repository = NoteRepository(dao)
    }

    val getAllNotes: LiveData<List<Note>> = repository.getAllNotes

    fun insertNote(note: Note) =viewModelScope.launch(Dispatchers.IO) {
        repository.insert(note)
    }

    fun deleteNote(noteIds: List<Int?>) = viewModelScope.launch(Dispatchers.IO) {
        repository.delete(noteIds)
    }

    fun updateNote(id: Int, name: String, contact: String) = viewModelScope.launch(Dispatchers.IO) {
        repository.update(id, name, contact)
    }
}