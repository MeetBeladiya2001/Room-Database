package com.example.roomdatabase.RoomData

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "note")
data class Note(
    @PrimaryKey (autoGenerate = true)
    val id: Int?,
    val name: String,
    val contact: String
):java.io.Serializable
