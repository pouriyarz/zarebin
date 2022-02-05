package com.example.gallery.util

import android.app.Activity
import android.content.Intent
import android.net.Uri

open class PickerBuilder(activity: Activity?, type: Int) {

    companion object {
        const val SELECT_FROM_GALLERY = 0
        const val SELECT_FROM_CAMERA = 1
    }

    private val permissionRefusedListener: OnPermissionRefusedListener? = null
    private var imageReceivedListener: OnImageReceivedListener? = null
    private var activity: Activity? = null
    private var pickerManager: PickerManager? = null

    init {
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
        val intent = Intent(activity, TempActivity::class.java)
        activity?.startActivity(intent)
        GlobalHolder.getInstance()?.setPickerManager(pickerManager)
    }

    fun setOnImageReceivedListener(listener: OnImageReceivedListener?): PickerBuilder {
        this.imageReceivedListener = listener
        pickerManager?.setOnImageReceivedListener(listener)
        return this
    }

    fun setOnPermissionRefusedListener(listener: OnPermissionRefusedListener?): PickerBuilder? {
        pickerManager?.setOnPermissionRefusedListener(listener)
        return this
    }

    fun setCropScreenColor(cropScreenColor: Int): PickerBuilder? {
        pickerManager?.setCropActivityColor(cropScreenColor)
        return this
    }

    fun setImageName(imageName: String?): PickerBuilder? {
        pickerManager?.setImageName(imageName)
        return this
    }

    fun withTimeStamp(withTimeStamp: Boolean): PickerBuilder? {
        pickerManager?.withTimeStamp(withTimeStamp)
        return this
    }

    fun setImageFolderName(folderName: String?): PickerBuilder? {
        pickerManager?.setImageFolderName(folderName)
        return this
    }

    fun setCustomizedUcrop(x: Int, y: Int): PickerBuilder? {
        pickerManager?.setCustomizedUcrop(x, y)
        return this
    }
}