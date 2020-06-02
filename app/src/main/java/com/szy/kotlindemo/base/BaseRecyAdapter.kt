package com.szy.kotlindemo.base

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import java.util.*

abstract class BaseRecyAdapter<VH : RecyclerView.ViewHolder, T> (mContext: Context) : Adapter<VH>() {

    protected var data = ArrayList<T>()
    protected var mInflater: LayoutInflater? = null
    protected var mContext: Context? = null
    protected var onItemClickListener: OnItemClickListener? = null
    protected var onItemLongListener: OnItemLongListener? = null

    init {
        this.mContext = mContext
        mInflater = LayoutInflater.from(mContext)
    }


    override fun getItemCount(): Int {
        return data.size
    }


    open fun getdata(): List<T> {
        return data
    }

    /**
     * 将旧数据清除，添加新数据
     *
     * @param datas
     */
    open fun setDataList(datas: List<T>?) {
        data.clear()
        datas?.let {
            data.addAll(it)
        }
        notifyDataSetChanged()
    }

    /**
     * 在列表底部添加新的数据集合
     *
     * @param newData
     */
    open fun addBottonDatas(newData: List<T>?) {
        newData?.let {
            data.addAll(it)
        }
        notifyDataSetChanged()
    }

    /**
     * 根据item的位置获取item对应的数据
     *
     * @param position
     * @return
     */
    open fun getItemData(position: Int): T? {
        return if (position < data.size) {
            data[position]
        } else {
            null
        }
    }

    /**
     * 设置item的长按事件
     *
     * @param onItemLongListener
     */
    open fun setOnItemLongListener(onItemClickListener: OnItemClickListener) {
        this.onItemClickListener = onItemClickListener
    }

    /**
     * 设置item的点击事件
     *
     * @param onItemClickListener
     */
    open fun setOnItemClickListener(onItemLongListener: OnItemLongListener) {
        this.onItemLongListener = onItemLongListener
    }

    /**
     * 在列表底部添加新的数据
     *
     * @param entity
     */
    open fun addBottonData(entity: T) {
        data.add(entity)
        notifyDataSetChanged()
    }

    interface OnItemClickListener {
        fun Onclick(position: Int, data: Any?)
    }

    interface OnItemLongListener {
        fun Onlong(position: Int, data: Any?)
    }
}