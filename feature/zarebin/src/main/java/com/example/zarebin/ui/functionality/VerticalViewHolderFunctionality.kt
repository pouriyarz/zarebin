package com.example.zarebin.ui.functionality

import androidx.core.content.ContextCompat
import com.example.zarebin.R
import com.example.zarebin.data.model.ZarebinModel
import com.example.zarebin.ui.adapter.VerticalViewHolder

fun VerticalViewHolder.render(data: ZarebinModel) {
    binding.apply {
        name.text = data.title

        if (bindingAdapterPosition % 2 == 0)
            card.setBackgroundColor(ContextCompat.getColor(name.context, R.color.clr_brown1))
        else
            card.setBackgroundColor(ContextCompat.getColor(name.context, R.color.clr_main1))
    }
}