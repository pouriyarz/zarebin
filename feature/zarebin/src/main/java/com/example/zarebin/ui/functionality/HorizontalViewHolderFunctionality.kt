package com.example.zarebin.ui.functionality

import androidx.core.content.ContextCompat.getColor
import com.example.zarebin.R
import com.example.zarebin.data.model.ZarebinModel
import com.example.zarebin.ui.adapter.HorizontalViewHolder

fun HorizontalViewHolder.render(data: ZarebinModel) {
    binding.apply {
        name.text = data.title

        if (bindingAdapterPosition % 2 == 0)
            card.setBackgroundColor(getColor(name.context, R.color.clr_brown1))
        else
            card.setBackgroundColor(getColor(name.context, R.color.clr_main1))
    }
}