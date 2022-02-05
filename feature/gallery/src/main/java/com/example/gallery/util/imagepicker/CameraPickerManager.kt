package com.example.gallery.util.imagepicker

import android.app.Activity
import android.content.ContentValues
import android.content.Intent
import android.net.Uri
import android.provider.MediaStore

class CameraPickerManager(activity: Activity?) : PickerManager(activity) {
    override fun sendToExternalApp() {
        val values = ContentValues(1).also {
            it.put(MediaStore.Images.Media.MIME_TYPE, "image/jpeg")
            mProcessingPhotoUri = activity?.contentResolver
                ?.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, it)
        }
        Intent(MediaStore.ACTION_IMAGE_CAPTURE).addFlags(
            Intent.FLAG_GRANT_READ_URI_PERMISSION
                    or Intent.FLAG_GRANT_WRITE_URI_PERMISSION
        ).putExtra(MediaStore.EXTRA_OUTPUT, mProcessingPhotoUri).also {
            activity?.startActivityForResult(it, REQUEST_CODE_SELECT_IMAGE)
        }
    }

    override fun setUri(uri: Uri?) {
    }
}