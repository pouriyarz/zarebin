package com.example.gallery.ui.fragments

import android.os.Bundle
import android.view.View
import com.example.base.BaseBottomSheetDialogFragment
import com.example.gallery.R
import com.example.gallery.databinding.ImagePickerBottomSheetBinding
import com.example.gallery.di.component.PickerBottomSheetComponent
import com.example.gallery.di.factory.PickerBottomSheetFactory
import com.example.gallery.ui.functionalities.render

class ImagePickerDialogFragment :
    BaseBottomSheetDialogFragment<ImagePickerBottomSheetBinding>(R.layout.image_picker_bottom_sheet) {

    private var pickerBottomSheetComponent: PickerBottomSheetComponent? = null

    companion object {
        var listener: ItemClickListener? = null
        fun setItemListener(listener: ItemClickListener) {
            this.listener = listener
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        listenToView()
    }

    interface ItemClickListener {
        fun onItemClick(item: Int)
    }

    override fun getViewBinding(): ImagePickerBottomSheetBinding =
        ImagePickerBottomSheetBinding.inflate(layoutInflater)

    override fun inject() {
        pickerBottomSheetComponent = PickerBottomSheetFactory.create().also {
            it.inject(this)
        }
    }

    override fun release() {
        pickerBottomSheetComponent = null
    }

    override fun listenToView() = render()
}