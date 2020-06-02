package com.szy.kotlindemo.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.szy.kotlindemo.R
import com.szy.kotlindemo.base.BaseRecyAdapter

class ItemInspectionAdapter(mContext: Context) :BaseRecyAdapter<ItemInspectionAdapter.ViewHoder,String>(mContext) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHoder {
       return ViewHoder(mInflater!!.inflate(R.layout.item_inspection_adapter,parent,false))
    }

    override fun onBindViewHolder(holder: ViewHoder, position: Int) {
    }
    class ViewHoder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        init {

        }
    }
}