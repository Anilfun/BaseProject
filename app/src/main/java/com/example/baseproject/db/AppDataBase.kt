package com.example.baseproject.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.baseproject.db.dao.StaffDao
import com.example.baseproject.db.model.Staff

@Database(
    entities = [Staff::class],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {
    abstract val staffDao: StaffDao
}
