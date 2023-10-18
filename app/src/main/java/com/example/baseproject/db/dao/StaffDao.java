package com.example.baseproject.db.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.baseproject.db.model.Staff;

import java.util.List;

@Dao
public abstract class StaffDao {

    @Query("SELECT * FROM `Staff` where staffId = :id")
    public abstract Staff getById(String id);
    @Insert
    public abstract long insert(Staff Staffs);

    @Query("DELETE FROM `Staff` WHERE staffId = :id")
    public abstract void deleteById(String id);
    @Update
    public abstract void update(Staff remote);

}
