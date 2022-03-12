package com.example.zarebin.ui.adapter

import com.example.recyclerview.base.BaseViewHolder
import com.example.zarebin.data.model.ZarebinModel
import com.example.zarebin.databinding.HorizontalItemBinding
import com.example.zarebin.ui.functionality.render

class HorizontalViewHolder(
    val binding: HorizontalItemBinding,
) : BaseViewHolder<ZarebinModel>(binding.root) {
    override fun bindData(data: ZarebinModel) = render(data)
}