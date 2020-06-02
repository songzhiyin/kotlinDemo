package com.szy.kotlindemo.adapter

import android.content.Context
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.szy.kotlindemo.R
import com.szy.kotlindemo.base.BaseRecyAdapter
import kotlinx.android.synthetic.main.item_home_menu_adapter.view.*

class ItemHomeMenuAdapter(mContext: Context) :
    BaseRecyAdapter<ItemHomeMenuAdapter.ViewHoder, String>(mContext) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHoder {
        return ViewHoder(mInflater!!.inflate(R.layout.item_home_menu_adapter, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHoder, position: Int) {
        var name = getItemData(position)
        var viewHoder = holder as ViewHoder
        viewHoder.tvName.text = name
        viewHoder.itemView.setOnClickListener {
            onItemclickListener?.let {
                it.Onclick(position, name)
            }
        }
    }

    class ViewHoder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvName: TextView = itemView.findViewById(R.id.tvName)

    }
}