package com.szy.kotlindemo.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.szy.kotlindemo.R
import com.szy.kotlindemo.base.BaseRecyAdapter
import com.szy.kotlindemo.db.entity.OrderListEntity
import com.szy.lib.network.Glide.GlideHelper
import kotlinx.android.synthetic.main.item_order_list_adapter.view.*

class ItemOrderListAdapter(mContext: Context) :
    BaseRecyAdapter<ItemOrderListAdapter.ViewHoder, OrderListEntity>(mContext) {
    inner class ViewHoder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvType: TextView = itemView.findViewById(R.id.tvType)
        var tvCode: TextView = itemView.findViewById(R.id.tvCode)
        var tvTime: TextView = itemView.findViewById(R.id.tvTime)
        var tvMessage: TextView = itemView.findViewById(R.id.tvMessage)
        var imgIcon: ImageView = itemView.findViewById(R.id.imgIcon)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHoder {
        return ViewHoder(mInflater!!.inflate(R.layout.item_order_list_adapter, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHoder, position: Int) {
        var entity = getItemData(position)
        var viewHoder = holder
        GlideHelper.showImage(mContext, entity!!.imgHead, viewHoder.imgIcon)
        viewHoder.tvCode.text = "单号：${entity.orderCode}"
        viewHoder.tvTime.text = "时间：${entity.createTime}"
        viewHoder.tvMessage.text = "内容：${entity.message}"
        viewHoder.tvType.text = "类型：${entity.type}"
        viewHoder.itemView.setOnLongClickListener {
            onItemlongListener?.let {
                it.Onlong(position, entity)
            }
            true
        }
    }
}