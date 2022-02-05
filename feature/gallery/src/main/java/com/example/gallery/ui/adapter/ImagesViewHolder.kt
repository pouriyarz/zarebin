package com.example.gallery.ui.adapter

import android.net.Uri
import com.bumptech.glide.RequestManager
import com.example.gallery.databinding.ImageItemBinding
import com.example.gallery.ui.functionalities.render
import com.example.gallery.ui.listener.OnRemoveFileListener
import com.example.recyclerview.base.BaseViewHolder

class ImagesViewHolder(
    val binding: ImageItemBinding,
    val requestManager: RequestManager,
    val onRemoveFileListener: OnRemoveFileListener,
) : BaseViewHolder<Uri>(binding.root) {
    override fun bindData(data: Uri) = render(data)
}