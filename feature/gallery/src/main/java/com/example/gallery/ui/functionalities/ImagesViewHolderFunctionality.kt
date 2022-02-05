package com.example.gallery.ui.functionalities

import android.net.Uri
import com.example.gallery.ui.adapter.ImagesViewHolder

fun ImagesViewHolder.render(data: Uri) {
    binding.apply {
        requestManager.load(data).into(image)

        removeImage.setOnClickListener {
            onRemoveFileListener.onRemoved(bindingAdapterPosition)
        }
    }
}