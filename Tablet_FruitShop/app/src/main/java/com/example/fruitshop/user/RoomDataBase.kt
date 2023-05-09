package com.example.fruitshop.user

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [RoomEntity::class], version = 1, exportSchema = false)
abstract class RoomDataBase: RoomDatabase(){

    abstract val roomDao: RoomDao
    companion object {
        @Volatile
        private var INSTANCE: RoomDataBase? = null

        fun getInstance(context: Context): RoomDataBase {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        RoomDataBase::class.java,
                        "room_database"
                    ).build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}