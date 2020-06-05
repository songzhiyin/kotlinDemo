package com.szy.kotlindemo.db

import android.content.Context
import android.util.Log
import com.szy.kotlindemo.db.dao.OrderListDao
import com.szy.kotlindemo.db.entity.OrderListEntity
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors


object OrderListHelp {
    private val TAG = "roomSQL"
    private var service: ExecutorService? = null
    fun insert(mContext: Context, entity: OrderListEntity) {
        initExecutors()
        service?.let {
            it.execute {
                val id = getDao(mContext).insertEnity(entity)
                Log.i(TAG, "保存数据成功，数据的id是$id")
            }
        }

    }
    fun insertAll(mContext: Context, data: ArrayList<OrderListEntity>) {
        initExecutors()
        service?.let {
            it.execute {
                val id = getDao(mContext).insertData(data)
                Log.i(TAG, "保存数据成功，数据的id是${id}")
            }
        }

    }

    fun delete(mContext: Context, entity: OrderListEntity) {
        initExecutors()
        service?.let {
            it.execute {
                getDao(mContext).deleteEntity(entity)
            }
        }
    }

    fun cleanData(mContext: Context) {
        initExecutors()
        service?.let {
            it.execute {
                getDao(mContext).cleanAllData()
            }
        }
    }
    fun cleanDataByType(mContext: Context,type:Int) {
        initExecutors()
        service?.let {
            it.execute {
                getDao(mContext).deleteEntityByType(type)
            }
        }
    }


    fun getAllData(mContext: Context, lisetener: OnLoadLisetener<List<OrderListEntity>>) {
        Observable.create<List<OrderListEntity>> {
            var data = getDao(mContext).loadAllEntity()
            it.onNext(data ?: ArrayList<OrderListEntity>())
        }.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                val data = it
                lisetener?.let {
                    Log.i(TAG, "获取到的数据: ${data.size}个数据")
                    it.onSucced(data)
                }
            }
    }


    private fun getDao(mContext: Context): OrderListDao {
        return AppDataBase.getDatabase(mContext).OrderListDao()
    }

    private fun initExecutors() {
        if (service == null) {
            service = Executors.newSingleThreadExecutor();
        }
    }


}