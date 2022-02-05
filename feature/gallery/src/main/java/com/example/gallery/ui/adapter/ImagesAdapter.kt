package com.example.gallery.ui.adapter

import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import com.bumptech.glide.RequestManager
import com.example.gallery.databinding.ImageItemBinding
import com.example.gallery.ui.listener.OnRemoveFileListener
import com.example.recyclerview.base.BaseAdapter

class ImagesAdapter constructor(
    var filesList: ArrayList<Uri>,
    private val requestManager: RequestManager,
    private val onRemoveFileListener: OnRemoveFileListener,
) : BaseAdapter<ImagesViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): ImagesViewHolder {
        return ImagesViewHolder(
            ImageItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ),
            requestManager,
            onRemoveFileListener
        )
    }

    override fun onBindViewHolder(holder: ImagesViewHolder, position: Int) {
        holder.bindData(filesList[position])
    }

    override fun getItemCount(): Int {
        return filesList.size
    }
}