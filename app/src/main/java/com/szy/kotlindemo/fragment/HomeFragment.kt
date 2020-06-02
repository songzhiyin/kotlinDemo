package com.szy.kotlindemo.fragment

import com.szy.kotlindemo.R
import com.szy.kotlindemo.adapter.BannerImaAdapter
import com.szy.kotlindemo.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : BaseFragment() {
    override fun getContentViewResId(): Int {
        return R.layout.fragment_home
    }

    override fun initView() {
        super.initView()

    }

    override fun initdata() {
        super.initdata()
        var dataImg=ArrayList<String>()
        dataImg.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1591088193470&di=c2f77fb1cc0a5b93a27afb5c7512f297&imgtype=0&src=http%3A%2F%2Fimg.51miz.com%2FElement%2F00%2F71%2F46%2F82%2Ffffc6885_E714682_92040862.jpg%2521%2Fquality%2F90%2Funsharp%2Ftrue%2Fcompress%2Ftrue%2Fformat%2Fjpg")
        dataImg.add("https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=1211338343,1056512950&fm=26&gp=0.jpg")
        dataImg.add("https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=1659872554,2076897818&fm=26&gp=0.jpg")
        banner.adapter=BannerImaAdapter(dataImg)
    }


}