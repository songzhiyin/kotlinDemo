package com.szy.kotlindemo.activity.home

import android.os.Handler
import androidx.fragment.app.*
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.szy.kotlindemo.R
import com.szy.kotlindemo.base.BaseActivity
import com.szy.kotlindemo.fragment.HomeFragment
import com.szy.kotlindemo.fragment.OrderListFragment
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : BaseActivity() {
    var dataFragment = ArrayList<Fragment>()
    var adapter: FragmentStateAdapter? = null
    lateinit var handler: Handler
    override fun getContentId(): Int {
        hideStatusBar()
        return (R.layout.activity_home)
    }

    override fun initView() {
        super.initView()
        adapter = ScreenSlidePagerAdapter(this)
        mViewpager.adapter = adapter
    }

    override fun initData() {
        super.initData()
        dataFragment.add(HomeFragment())
        dataFragment.add(OrderListFragment())
        dataFragment.add(HomeFragment())
        adapter?.notifyDataSetChanged()
    }

    /**
     * A simple pager adapter that represents 5 ScreenSlidePageFragment objects, in
     * sequence.
     */
    private inner class ScreenSlidePagerAdapter(fa: FragmentActivity) :
        FragmentStateAdapter(fa) {
        override fun getItemCount(): Int {
            return dataFragment.size
        }

        override fun createFragment(position: Int): Fragment {
            return dataFragment[position]
        }

    }



}
