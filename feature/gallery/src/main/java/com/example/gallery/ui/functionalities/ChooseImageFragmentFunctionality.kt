package com.example.gallery.ui.functionalities

import android.net.Uri
import com.example.base.behaviour.navigate
import com.example.gallery.R
import com.example.gallery.ui.fragments.ChooseImageFragment
import com.example.gallery.ui.fragments.ImagePickerDialogFragment
import com.example.gallery.util.PickerBuilder

fun ChooseImageFragment.render() {
    binding.apply {
        choose.setOnClickListener {
            navigate(R.id.action_chooseImageFragment_to_imagePickerDialogFragment)
        }

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
            override fun onImageReceived(imageUri: Uri?) {
//                setToImageView(imageUri)
                val selectedImage = imageUri
            }
        })
        ?.setImageName("ads")
        ?.setImageFolderName("MyAds")
        ?.setCustomizedUcrop(1, 1)
        ?.start()
}

fun ChooseImageFragment.selectFromCamera() {
    PickerBuilder(requireActivity(), PickerBuilder.SELECT_FROM_CAMERA)
        .setOnImageReceivedListener(object : PickerBuilder.OnImageReceivedListener {
            override fun onImageReceived(imageUri: Uri?) {
//                setToImageView(imageUri)
                val selectedImage = imageUri
            }
        })
        ?.setImageName("ads")
        ?.setImageFolderName("MyAds")
        ?.setCustomizedUcrop(1, 1)
        ?.start()
}