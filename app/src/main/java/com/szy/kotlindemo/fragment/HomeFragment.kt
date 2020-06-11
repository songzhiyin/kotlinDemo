package com.szy.kotlindemo.fragment

import android.content.Intent
import androidx.recyclerview.widget.GridLayoutManager
import com.szy.kotlindemo.R
import com.szy.kotlindemo.activity.*
import com.szy.kotlindemo.activity.launchMode.LaunchModel1Activity
import com.szy.kotlindemo.adapter.BannerImaAdapter
import com.szy.kotlindemo.adapter.ItemHomeMenuAdapter
import com.szy.kotlindemo.base.BaseFragment
import com.szy.kotlindemo.base.BaseRecyAdapter
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : BaseFragment() {
    var adapter: ItemHomeMenuAdapter? = null
    override fun getContentViewResId(): Int {
        return R.layout.fragment_home
    }

    override fun initView() {
        super.initView()
        adapter = ItemHomeMenuAdapter(mContext!!)
        recyHome.layoutManager = GridLayoutManager(activity, 3)
        recyHome.adapter = adapter
    }

    override fun initdata() {
        super.initdata()
        initBannerData()
        initMenuData()
    }

    fun initBannerData() {
        var data = ArrayList<String>()
        data.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1591088193470&di=c2f77fb1cc0a5b93a27afb5c7512f297&imgtype=0&src=http%3A%2F%2Fimg.51miz.com%2FElement%2F00%2F71%2F46%2F82%2Ffffc6885_E714682_92040862.jpg%2521%2Fquality%2F90%2Funsharp%2Ftrue%2Fcompress%2Ftrue%2Fformat%2Fjpg")
        data.add("https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=1211338343,1056512950&fm=26&gp=0.jpg")
        data.add("https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=1659872554,2076897818&fm=26&gp=0.jpg")
        banner.adapter = BannerImaAdapter(data)
    }

    fun initMenuData() {
        var data = ArrayList<String>()
        data.add("巡检列表")
        data.add("notification")
        data.add("相机照片")
        data.add("toolbar")
        data.add("左侧滑动菜单")
        data.add("卡片布局")
        data.add("viewmodel")
        data.add("liveData")
        data.add("workmanager")
        data.add("launchModel")
        adapter?.setDataList(data)
    }


    override fun initEvent() {
        super.initEvent()
        adapter?.setOnItemClickListener(onItemClick)
    }

    private var onItemClick = object : BaseRecyAdapter.OnItemClickListener {
        override fun Onclick(position: Int, data: Any?) {
            when (position) {
                0 -> {
                    startActivity<InspectionListActivity>(activity!!){
                       putExtra("top","生成新的嵌套滑动表格")
                       putExtra("top1","表格可以左右上下滑动")
                    }
                }
                1 -> {//发送notification
                    startActivity<NotificationActivity>(activity)
                }
                2 -> {//拍照和相册
                    startActivity<TakePhotoActivity>(activity)
                }
                3->{//toolbar
                    startActivity(Intent(activity, ToolbarActivity::class.java))
                }
                4->{//左侧滑动出现菜单
                    startActivity(Intent(activity, DrawerLayoutActivity::class.java))
                }
                5->{//卡片布局
                    startActivity(Intent(activity, MaterialCardViewActivity::class.java))
                }
                6 -> {//viewmodel
                    startActivity(Intent(activity, HourMeterActivity::class.java))
                }
                7 -> {//liveData
                    startActivity(Intent(activity, HourMeterActivity::class.java))
                }
                8 -> {//workmanager
                    startActivity(Intent(activity, WorkManagerActivity::class.java))
                }
                9->{//测试activity的launchModel——singtask
                    startActivity<LaunchModel1Activity>(activity)
                }
            }
        }

    }


}