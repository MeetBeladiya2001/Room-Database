package com.example.roomdatabase.RoomData

import androidx.lifecycle.LiveData

class NoteRepository(private val noteDao: NoteDao) {

    val getAllNotes: LiveData<List<Note>> = noteDao.getAllNotes()

    suspend fun insert(note: Note) {
        noteDao.insert(note)
    }
    suspend fun delete(noteIds: List<Int?>) {
        noteDao.delete(noteIds)
    }

    suspend fun update(id: Int, name: String, contact: String) {
        noteDao.update(id, name, contact)
    }
 }