package com.example.recyclerview.base

import androidx.recyclerview.widget.RecyclerView

abstract class BaseAdapter<T : BaseViewHolder<*>> : RecyclerView.Adapter<T>() {

    init {
        this.setHasStableIds(true)
    }
}