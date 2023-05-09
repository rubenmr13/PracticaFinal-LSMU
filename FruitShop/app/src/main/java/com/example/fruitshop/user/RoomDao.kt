package com.example.fruitshop.user

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface RoomDao {

    @Insert
    suspend fun insert(user: RoomEntity)

    @Query("SELECT room_password FROM room_table")
    fun getAllPasswords(): List<String>

   @Query("SELECT room_user FROM room_table")
   fun getAllNames(): List<String>

    @Query("SELECT * FROM room_table ORDER BY userId DESC")
    fun getAll(): LiveData<List<RoomEntity>>
}