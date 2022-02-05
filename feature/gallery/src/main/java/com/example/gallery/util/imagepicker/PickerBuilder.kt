package com.example.gallery.util.imagepicker

import android.app.Activity
import android.content.Intent
import android.net.Uri
import com.example.gallery.di.component.PickerBuilderComponent
import com.example.gallery.di.factory.PickerBuilderFactory
import javax.inject.Inject

open class PickerBuilder(activity: Activity?, type: Int) {

    companion object {
        const val SELECT_FROM_GALLERY = 0
        const val SELECT_FROM_CAMERA = 1
    }

    @Inject
    lateinit var globalHolder: GlobalHolder

    private var imageReceivedListener: OnImageReceivedListener? = null
    private var activity: Activity? = null
    private var pickerManager: PickerManager? = null
    private var pickerBuilderComponent: PickerBuilderComponent? = null

    init {
        pickerBuilderComponent = PickerBuilderFactory.create().also {
            it.inject(this)
        }
        this.activity = activity
        pickerManager =
            if (type == SELECT_FROM_GALLERY) ImagePickerManager(activity) else CameraPickerManager(
                activity
            )
    }

    interface OnPermissionRefusedListener {
        fun onPermissionRefused()
    }

    interface OnImageReceivedListener {
        fun onImageReceived(imageUri: Uri?)
    }

    fun start() {
        Intent(activity, TempActivity::class.java).also {
            activity?.startActivity(it)
        }
        globalHolder.setPickerManager(pickerManager)
    }

    fun setOnImageReceivedListener(listener: OnImageReceivedListener?): PickerBuilder {
        this.imageReceivedListener = listener
        pickerManager?.setOnImageReceivedListener(listener)
        return this
    }

    fun setImageName(imageName: String?): PickerBuilder {
        pickerManager?.setImageName(imageName)
        return this
    }

    fun setImageFolderName(folderName: String?): PickerBuilder {
        pickerManager?.setImageFolderName(folderName)
        return this
    }

    fun setCustomizedUcrop(x: Double, y: Double): PickerBuilder {
        pickerManager?.setCustomizedUcrop(x, y)
        return this
    }
}