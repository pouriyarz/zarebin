package com.example.zarebin.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.recyclerview.base.BaseAdapter
import com.example.zarebin.data.model.ZarebinModel
import com.example.zarebin.databinding.VerticalItemBinding

class VerticalAdapter constructor(
    var list: ArrayList<ZarebinModel>,
) : BaseAdapter<VerticalViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VerticalViewHolder {
        return VerticalViewHolder(
            VerticalItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ))
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun onBindViewHolder(holder: VerticalViewHolder, position: Int) {
        holder.bindData(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }
}