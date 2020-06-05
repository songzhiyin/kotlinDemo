package com.szy.kotlindemo.db.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Update
import com.szy.kotlindemo.db.entity.DrugEntity

@Dao
interface DrugDao {
    @Insert
    fun insertData(entity: DrugEntity):Long

    @Update
    fun updateData(entity: DrugEntity)

    @Delete
    fun deleteData(entity: DrugEntity)

}