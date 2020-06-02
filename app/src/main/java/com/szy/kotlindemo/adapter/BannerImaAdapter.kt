package com.szy.kotlindemo.adapter

import android.content.Context
import android.view.ViewGroup
import android.widget.ImageView
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView
import com.szy.lib.network.Glide.GlideHelper
import com.youth.banner.adapter.BannerAdapter

class BannerImaAdapter(data:ArrayList<String>) :BannerAdapter<String,BannerImaAdapter.BannerViewHoder>(data){
    private var mContext:Context?=null
    class BannerViewHoder(@NonNull view: ImageView) : RecyclerView.ViewHolder(view) {
         var imageView: ImageView = view

    }

    override fun onCreateHolder(parent: ViewGroup?, viewType: Int): BannerViewHoder {
        mContext=parent?.context
        val imageView=ImageView(mContext)
        //注意view的宽高必须设置为MATCH_PARENT，这个是viewpager2要求的
        imageView.layoutParams=ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT)
        return BannerViewHoder(imageView)
    }

    override fun onBindView(holder: BannerViewHoder?, data: String?, position: Int, size: Int) {
        mContext?.let {
            holder?.imageView?.scaleType=ImageView.ScaleType.CENTER_CROP
            GlideHelper.showImage(it,data,holder?.imageView)
        }
    }
}