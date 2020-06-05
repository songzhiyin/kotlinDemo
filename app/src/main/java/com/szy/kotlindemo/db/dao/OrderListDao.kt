package com.szy.kotlindemo.db.dao

import androidx.room.*
import com.szy.kotlindemo.db.entity.OrderListEntity

@Dao
interface OrderListDao {
    @Insert
    fun insertEnity(entity: OrderListEntity): Long

    @Insert
    fun insertData(data:ArrayList<OrderListEntity>):List<Long>

    @Update
    fun updateEntity(entity: OrderListEntity)

    @Query("select * from OrderListEntity")
    fun loadAllEntity(): List<OrderListEntity>

    @Query("select * from OrderListEntity where type=:type")
    fun longAllEntity(type:Int):List<OrderListEntity>

    @Delete
    fun deleteEntity(entity: OrderListEntity)

    /**
     * 删除所有的type==code的数据
     */
    @Query("delete from OrderListEntity where type=:code")
    fun deleteEntityByType(code: Int):Int

    @Query("delete from OrderListEntity")
    fun cleanAllData()
}