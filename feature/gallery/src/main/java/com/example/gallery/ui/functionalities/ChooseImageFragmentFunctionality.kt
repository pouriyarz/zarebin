package com.example.gallery.ui.functionalities

import android.annotation.SuppressLint
import android.net.Uri
import android.view.View
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.GridLayoutManager
import com.example.base.behaviour.navigate
import com.example.gallery.R
import com.example.gallery.ui.adapter.ImagesAdapter
import com.example.gallery.ui.fragments.ChooseImageFragment
import com.example.gallery.ui.fragments.ImagePickerDialogFragment
import com.example.gallery.ui.listener.OnRemoveFileListener
import com.example.gallery.util.imagepicker.PickerBuilder

fun ChooseImageFragment.render() {
    binding.apply {
        choose.setOnClickListener {
            navigate(R.id.action_chooseImageFragment_to_imagePickerDialogFragment)
        }
        createAdapter()

        ImagePickerDialogFragment.setItemListener(object :
            ImagePickerDialogFragment.ItemClickListener {
            override fun onItemClick(item: Int) {
                if (item == 1) {
                    selectFromCamera()
                } else {
                    selectFromGallery()
                }
            }
        })
    }
}

fun ChooseImageFragment.selectFromGallery() {
    PickerBuilder(requireActivity(), PickerBuilder.SELECT_FROM_GALLERY)
        .setOnImageReceivedListener(object : PickerBuilder.OnImageReceivedListener {
            @SuppressLint("NotifyDataSetChanged")
            override fun onImageReceived(imageUri: Uri?) {
                imageUri?.let { filesList.add(it) }
                checkEmptyList()
                imagesAdapter.notifyDataSetChanged()
            }
        })
        .setImageName("otaghak")
        .setImageFolderName("MyOtaghak")
        .start()
}

fun ChooseImageFragment.selectFromCamera() {
    PickerBuilder(requireActivity(), PickerBuilder.SELECT_FROM_CAMERA)
        .setOnImageReceivedListener(object : PickerBuilder.OnImageReceivedListener {
            @SuppressLint("NotifyDataSetChanged")
            override fun onImageReceived(imageUri: Uri?) {
                imageUri?.let { filesList.add(it) }
                checkEmptyList()
                imagesAdapter.notifyDataSetChanged()
            }
        })
        .setImageName("otaghak")
        .setImageFolderName("MyOtaghak")
        .setCustomizedUcrop(1.0, 1.2)
        .start()
}

fun ChooseImageFragment.createAdapter() {
    binding.apply {
        imagesAdapter =
            ImagesAdapter(filesList, requestManager, onRemoveFileImp())
        imagesRecyclerView.also {
            it.layoutManager = GridLayoutManager(
                requireActivity(),
                2
            )
            it.itemAnimator = DefaultItemAnimator()
            it.adapter = imagesAdapter
        }
    }
}

fun ChooseImageFragment.onRemoveFileImp(): OnRemoveFileListener {
    return object : OnRemoveFileListener {
        override fun onRemoved(position: Int) {
            filesList.removeAt(position)
            imagesAdapter.notifyItemRemoved(position)
            checkEmptyList()
        }
    }
}

fun ChooseImageFragment.checkEmptyList() {
    binding.apply {
        if (filesList.size == 0) {
            emptyHint.visibility = View.VISIBLE
        } else {
            emptyHint.visibility = View.GONE
        }
    }
}