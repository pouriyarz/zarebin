package com.example.gallery.ui.functionalities

import com.example.gallery.ui.fragments.ImagePickerDialogFragment
import com.example.gallery.ui.fragments.ImagePickerDialogFragment.Companion.listener

fun ImagePickerDialogFragment.render() {
    binding.apply {
        cameraSelect.setOnClickListener {
            listener?.onItemClick(1)
            dismiss()
        }
        gallerySelect.setOnClickListener {
            listener?.onItemClick(2)
            dismiss()
        }
    }
}