package com.example.fruitshop.user

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "room_table")
class RoomEntity (
    @PrimaryKey(autoGenerate = true) var userId: Int = 0,
    @ColumnInfo(name = "room_user") var roomName: String = "",
    @ColumnInfo(name = "room_password") var roomPassword: String = ""
)
