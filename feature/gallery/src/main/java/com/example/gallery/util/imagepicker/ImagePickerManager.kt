package com.example.gallery.util.imagepicker

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.provider.MediaStore

class ImagePickerManager(activity: Activity?) : PickerManager(activity) {

    override fun sendToExternalApp() {
        Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI).also {
            it.type = "image/*"
            activity?.startActivityForResult(
                Intent.createChooser(it, "Select Image..."),
                REQUEST_CODE_SELECT_IMAGE
            )
        }
    }

    override fun setUri(uri: Uri?) {
        mProcessingPhotoUri = uri
    }
}