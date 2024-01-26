package com.example.gardeningjournalapp.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "plant_table")
data class Plant(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val plantName: String,
    val plantType: String,
    val waterFrequency: Int,
    val plantDate: String
)