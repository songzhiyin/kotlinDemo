package com.szy.kotlindemo.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.szy.kotlindemo.db.dao.FoodDao
import com.szy.kotlindemo.db.dao.OrderListDao
import com.szy.kotlindemo.db.entity.FoodEntity
import com.szy.kotlindemo.db.entity.OrderListEntity

@Database(version = 3, entities = [OrderListEntity::class, FoodEntity::class])
abstract class AppDataBase : RoomDatabase() {
    abstract fun OrderListDao(): OrderListDao
    abstract fun FoodDao(): FoodDao

    companion object {
        val MIGRATION_1_2 = object : Migration(1, 2) {
            override fun migrate(database: SupportSQLiteDatabase) {
                //FoodEntity表添加了一列createTime，kotlin创建的entity对象中的参数如果没有强制声明可以为空，那么SQL语句中也要强制写明不能为空否则会报错
                database.execSQL("alter table FoodEntity add column createTime text not null default 'unknown'")
            }
        }
        val MIGRATION_2_3 = object : Migration(2, 3) {
            override fun migrate(database: SupportSQLiteDatabase) {
                //FoodEntity表添加了一列finishTime,kotlin创建的entity对象中的参数如果没有强制声明可以为空，那么SQL语句中也要强制写明不能为空否则会报错
                database.execSQL("alter table FoodEntity add column finishTime text  default 'unknown'")
            }

        }

        val MIGRATION_7_8 = object : Migration(7, 8) {
            override fun migrate(database: SupportSQLiteDatabase) {
                //添加一个新表(Book)参数 id为主键自增长 name为string类型 pages为int类型
                database.execSQL("create table Book (id integer primary key autoincrement not null,name text not null ,pages integer not null)")
            }
        }
        private var instance: AppDataBase? = null

        @Synchronized
        fun getDatabase(mContext: Context): AppDataBase {
            instance?.let {
                return it
            }
            return Room.databaseBuilder(
                mContext.applicationContext, AppDataBase::class.java, "app_database"
            )
                .addMigrations(MIGRATION_1_2, MIGRATION_2_3)//升级数据库
                .build()
                .apply {
                    instance = this
                }
        }
    }
}