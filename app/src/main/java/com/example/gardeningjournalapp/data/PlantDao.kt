package com.example.gardeningjournalapp.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface PlantDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addPlant(plant: Plant)

    @Query("SELECT * FROM plant_table ORDER BY id ASC")
    fun readAllData(): LiveData<List<Plant>>

}