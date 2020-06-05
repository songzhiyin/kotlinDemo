package com.szy.kotlindemo.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.szy.kotlindemo.db.dao.FoodDao
import com.szy.kotlindemo.db.dao.OrderListDao
import com.szy.kotlindemo.db.entity.FoodEntity
import com.szy.kotlindemo.db.entity.OrderListEntity

@Database(version = 1, entities = [OrderListEntity::class,FoodEntity::class])
abstract class AppDataBase : RoomDatabase() {
    abstract fun OrderListDao(): OrderListDao
    abstract fun FoodDao(): FoodDao

    companion object {
        private var instance: AppDataBase? = null

        @Synchronized
        fun getDatabase(mContext: Context): AppDataBase {
            instance?.let {
                return it
            }
            return Room.databaseBuilder(
                mContext.applicationContext, AppDataBase::class.java
                , "app_database"
            ).build().apply {
                instance = this
            }
        }
    }
}