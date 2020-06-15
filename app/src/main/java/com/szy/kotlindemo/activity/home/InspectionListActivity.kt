package com.szy.kotlindemo.activity.home

import android.view.LayoutInflater
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.szy.kotlindemo.R
import com.szy.kotlindemo.adapter.ItemInspectionAdapter
import com.szy.kotlindemo.base.BaseActivity
import kotlinx.android.synthetic.main.activity_inspection_list.*

/**
 * 巡检列表
 */
class InspectionListActivity : BaseActivity() {
    var adapter: ItemInspectionAdapter? = null
    override fun getContentId(): Int {
        return (R.layout.activity_inspection_list)
    }

    override fun initView() {
        super.initView()
        setTitleName("巡检列表")
        mContext?.let {
            adapter = ItemInspectionAdapter(it)
        }
        recyList.isNestedScrollingEnabled = false
        recyList.adapter = adapter
        recyList.layoutManager = LinearLayoutManager(mContext)
    }

    override fun initEvent() {
        super.initEvent()
        setbackListener()
    }

    override fun initData() {
        super.initData()
        val data = ArrayList<String>()
        for (i in 0..20) {
            data.add("")
            initItemDataToUI()
        }
        adapter?.setDataList(data)
    }
    fun initItemDataToUI(){
        var itemView=LayoutInflater.from(this).inflate(R.layout.item_inspection_adapter,null)
        lineData.addView(itemView)
    }
}