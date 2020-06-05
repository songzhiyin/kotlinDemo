package com.szy.kotlindemo.fragment

import android.os.Handler
import android.view.View
import androidx.constraintlayout.solver.LinearSystem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.OrientationHelper
import com.szy.kotlindemo.R
import com.szy.kotlindemo.adapter.ItemOrderListAdapter
import com.szy.kotlindemo.base.BaseFragment
import com.szy.kotlindemo.base.BaseRecyAdapter
import com.szy.kotlindemo.db.OrderListHelp
import com.szy.kotlindemo.db.dao.OnLoadLisetener
import com.szy.kotlindemo.db.entity.OrderListEntity
import com.szy.kotlindemo.dialog.CommonDialog
import com.szy.kotlindemo.util.TimeUtil
import com.szy.kotlindemo.util.ToastUtil
import com.szy.lib.network.Retrofit.Util.DialogNetUtil
import kotlinx.android.synthetic.main.fragment_order_list.*
import kotlinx.android.synthetic.main.include_title_layout.*

class OrderListFragment : BaseFragment() {
    private var adapter: ItemOrderListAdapter? = null
    val imageData = arrayOf(
        "http://attach.bbs.miui.com/forum/201204/17/1539083wxpexg5b0fbvzpv.jpg",
        "http://img.pconline.com.cn/images/upload/upc/tx/wallpaper/1207/16/c0/12347336_1342406678053.jpg",
        "http://abc.2008php.com/2015_Website_appreciate/2015-08-01/20150801230704.jpg",
        "http://attachments.gfan.com/forum/attachments2/201304/18/001339jv88x0qs06vo3qq6.jpg"
    )

    override fun getContentViewResId(): Int {
        return R.layout.fragment_order_list
    }

    override fun initView() {
        super.initView()
        tvTitle.text = "订单列表"
        adapter = ItemOrderListAdapter(mContext!!)
        recyList.adapter = adapter
        recyList.layoutManager = LinearLayoutManager(mContext)


    }

    override fun initEvent() {
        super.initEvent()
        tvAdd.setOnClickListener {
            addEntity()
        }
        tvClean.setOnClickListener {
            OrderListHelp.cleanData(mContext!!)
            adapter?.setDataList(arrayListOf())
        }
        tvReset.setOnClickListener {
            initdata()
        }
        tvDelete2.setOnClickListener {
            OrderListHelp.cleanDataByType(mContext!!, 2)
            DialogNetUtil.start_NetworkRequests_diolog(mContext)
            Handler().postDelayed(Runnable {
                DialogNetUtil.close_NetworkRequests_diolog()
                initdata()
            }, 400)
        }
        adapter?.setOnItemLongListener(object : BaseRecyAdapter.OnItemLongListener {
            override fun Onlong(position: Int, data: Any?) {
                adapter!!.getItemData(position)?.let { showDeleteEntityDialog(it) }
            }
        })
    }

    fun showDeleteEntityDialog(entity: OrderListEntity) {
        var dialog = CommonDialog(mContext!!)
        dialog.setContentMessage("确定要删除这个数据吗")
        dialog.setonclickConfirm(object : CommonDialog.CallConfirmlistener {
            override fun onClick() {
                adapter?.remove(entity)
                OrderListHelp.delete(mContext!!, entity)
            }
        })
        dialog.show()
    }

    fun addEntity() {
        val imgPosition = (imageData.indices).random()
        val type = (1..4).random()
        var entity = OrderListEntity()
        entity.imgHead = imageData[imgPosition]
        entity.type = type
        var leftCode = (1000000000..10000000000).random()
        var rightCode = (1000..10000).random()
        entity.orderCode = "$leftCode$rightCode".toLong()
        entity.message = "这是一个悲伤的故事"
        entity.createTime = TimeUtil.getDateTimeStr(System.currentTimeMillis())
        OrderListHelp.insert(mContext!!, entity)
        adapter?.addBottonData(entity)
    }

    override fun initdata() {
        super.initdata()
        OrderListHelp.getAllData(mContext!!,
            object : OnLoadLisetener<List<OrderListEntity>> {
                override fun onSucced(data: List<OrderListEntity>) {
                    adapter?.setDataList(data ?: ArrayList<OrderListEntity>())
                    if (adapter!!.getdata().isEmpty()) {
                        addEntity()
                    }
                }
            })

    }
}