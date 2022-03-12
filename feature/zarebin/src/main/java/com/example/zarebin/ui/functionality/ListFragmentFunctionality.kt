package com.example.zarebin.ui.functionality

import android.view.MotionEvent
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.zarebin.ui.adapter.HorizontalAdapter
import com.example.zarebin.ui.adapter.VerticalAdapter
import com.example.zarebin.ui.fragment.ListFragment

fun ListFragment.render() {
    listViewModel.getList()
}

fun ListFragment.createVerticalAdapter() {
    binding.apply {
        val linearLayoutManager =
            LinearLayoutManager(
                requireActivity(),
                LinearLayoutManager.VERTICAL,
                false
            )
        verticalRecyclerView.layoutManager = linearLayoutManager
        verticalRecyclerView.itemAnimator = DefaultItemAnimator()
        verticalAdapter =
            VerticalAdapter(modelList)
        verticalRecyclerView.adapter = verticalAdapter
    }
}

fun ListFragment.createHorizontalAdapter() {
    binding.apply {
        val linearLayoutManager =
            LinearLayoutManager(
                requireActivity(),
                LinearLayoutManager.HORIZONTAL,
                false
            )
        horizontalRecyclerView.layoutManager = linearLayoutManager
        horizontalRecyclerView.itemAnimator = DefaultItemAnimator()
        horizontalAdapter =
            HorizontalAdapter(modelList)
        horizontalRecyclerView.adapter = horizontalAdapter

        val listener = object : RecyclerView.OnItemTouchListener {
            override fun onInterceptTouchEvent(rv: RecyclerView, e: MotionEvent): Boolean {
                val action = e.action
                if (horizontalRecyclerView.canScrollHorizontally(RecyclerView.FOCUS_FORWARD)) {
                    when (action) {
                        MotionEvent.ACTION_MOVE -> rv.parent
                            .requestDisallowInterceptTouchEvent(true)
                    }
                    return false
                } else {
                    when (action) {
                        MotionEvent.ACTION_MOVE -> rv.parent
                            .requestDisallowInterceptTouchEvent(false)
                    }
                    horizontalRecyclerView.removeOnItemTouchListener(this)
                    return true
                }
            }

            override fun onTouchEvent(rv: RecyclerView, e: MotionEvent) {}
            override fun onRequestDisallowInterceptTouchEvent(disallowIntercept: Boolean) {}
        }

        horizontalRecyclerView.addOnItemTouchListener(listener)
    }
}