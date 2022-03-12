package com.example.zarebin.ui.functionality

import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.zarebin.ui.adapter.ViewPagerAdapter
import com.example.zarebin.ui.fragment.GooglePlayFragment
import com.example.zarebin.ui.fragment.ListFragment
import com.example.zarebin.ui.fragment.ZarebinFragment
import com.example.zarebin.ui.fragment.ZarebinViewPagerFragment
import com.example.zarebin.util.ZoomOutPageTransformer

fun ZarebinViewPagerFragment.render() {
    binding.apply {
        val fragmentList = arrayListOf<Fragment>(
            ZarebinFragment(),
            ListFragment(),
            GooglePlayFragment()
        )
        viewPager.adapter = ViewPagerAdapter(fragmentList, requireActivity())
        viewPager.currentItem = 1
        viewPager.setPageTransformer(ZoomOutPageTransformer())
        viewPager.reduceDragSensitivity()
    }
}

fun ViewPager2.reduceDragSensitivity() {
    val recyclerViewField = ViewPager2::class.java.getDeclaredField("mRecyclerView")
    recyclerViewField.isAccessible = true
    val recyclerView = recyclerViewField.get(this) as RecyclerView

    val touchSlopField = RecyclerView::class.java.getDeclaredField("mTouchSlop")
    touchSlopField.isAccessible = true
    val touchSlop = touchSlopField.get(recyclerView) as Int
    touchSlopField.set(recyclerView, touchSlop * 8)       // "8" was obtained experimentally
}