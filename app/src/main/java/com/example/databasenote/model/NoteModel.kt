package com.example.databasenote.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "note_table")
data class NoteModel(
    @PrimaryKey(autoGenerate = true)
    val id:Int = 0,
    @ColumnInfo
    val title:String = "",
    @ColumnInfo
    val description:String = ""
):Serializable
