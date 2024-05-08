package com.example.roomdatabase.RoomData

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface NoteDao {

    @Insert (onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(note: Note)

    @Query ("DELETE FROM note WHERE id IN (:noteIds)")
    suspend fun delete(noteIds: List<Int?>)

    @Query("SELECT * FROM note ORDER BY id ASC")
    fun getAllNotes(): LiveData<List<Note>>

    @Query ("UPDATE note SET name = :name, contact = :contact WHERE id = :id")
    suspend fun update(id: Int, name: String, contact: String)

}