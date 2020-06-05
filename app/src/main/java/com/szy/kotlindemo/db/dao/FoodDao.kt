package com.szy.kotlindemo.db.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Update
import com.szy.kotlindemo.db.entity.FoodEntity

@Dao
interface FoodDao {
    @Insert
    fun insertData(entity: FoodEntity):Long

    @Update
    fun updateData(entity: FoodEntity)

    @Delete
    fun deleteData(entity: FoodEntity)

}