package com.example.gallery.util.imagepicker

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.gallery.R
import com.yalantis.ucrop.UCrop
import java.io.File
import java.text.SimpleDateFormat
import java.util.*

abstract class PickerManager(activity: Activity?) {
    companion object {
        const val REQUEST_CODE_SELECT_IMAGE = 200
        const val REQUEST_CODE_IMAGE_PERMISSION = 201
    }

    protected var mProcessingPhotoUri: Uri? = null
    private var folder: String? = null
    private var withTimeStamp = true
    private var imageName: String? = null
    protected var activity: Activity? = null
    private var uCrop: UCrop? = null
    private var xScale = 0F
    private var yScale = 0F
    var imageReceivedListener: PickerBuilder.OnImageReceivedListener? = null
    var permissionRefusedListener: PickerBuilder.OnPermissionRefusedListener? = null

    init {
        this.activity = activity
        imageName = activity?.getString(R.string.app_name)
    }

    fun setOnImageReceivedListener(listener: PickerBuilder.OnImageReceivedListener?): PickerManager {
        imageReceivedListener = listener
        return this
    }

    fun pickPhotoWithPermission() {
        activity?.let {
            when {
                ContextCompat.checkSelfPermission(
                    it,
                    Manifest.permission.READ_EXTERNAL_STORAGE
                ) !=
                        PackageManager.PERMISSION_GRANTED -> {
                    ActivityCompat.requestPermissions(
                        it, arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE),
                        REQUEST_CODE_IMAGE_PERMISSION
                    )
                }
                ContextCompat.checkSelfPermission(
                    it,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE
                ) !=
                        PackageManager.PERMISSION_GRANTED -> {
                    ActivityCompat.requestPermissions(
                        it, arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE),
                        REQUEST_CODE_IMAGE_PERMISSION
                    )
                }
                else -> sendToExternalApp()
            }
        }
    }

    fun handlePermissionResult(grantResults: IntArray) {
        if (grantResults.isNotEmpty()
            && grantResults[0] == PackageManager.PERMISSION_GRANTED
        ) {
            sendToExternalApp()
        } else {
            if (permissionRefusedListener != null) permissionRefusedListener?.onPermissionRefused()
            activity?.finish()
        }
    }

    protected abstract fun sendToExternalApp()

    fun getImageFile(): Uri? {
        ("$imageName _${
            SimpleDateFormat("yyyyMMdd_HHmmss", Locale.US).format(
                Date(
                    System.currentTimeMillis()
                )
            )
        }.jpg").also {
            File(activity?.filesDir?.path.toString(), it).also { file ->
                return Uri.fromFile(file)
            }
        }
    }

    abstract fun setUri(uri: Uri?)

    fun startCropActivity() {
        if (uCrop == null) {
            uCrop = mProcessingPhotoUri?.let { uri ->
                getImageFile()?.let { imageFile ->
                    UCrop.of(uri, imageFile).also {
                        it.withAspectRatio(xScale.toFloat(), yScale.toFloat())
                        it.withMaxResultSize(1000, 1000)
                    }
                }
            }
            UCrop.Options().also {
                it.setHideBottomControls(true)
                it.setFreeStyleCropEnabled(false)
                it.setCompressionQuality(90)
                it.setHideBottomControls(false)
                uCrop = uCrop?.withOptions(it)
            }
        }
        activity?.let { uCrop?.start(it) }
    }

    fun handleCropResult(data: Intent?) {
        val resultUri = data?.let { UCrop.getOutput(it) }
        if (imageReceivedListener != null) imageReceivedListener?.onImageReceived(resultUri)
        activity?.finish()
    }

    fun setActivity(activity: Activity?): PickerManager {
        this.activity = activity
        return this
    }

    fun setImageName(imageName: String?): PickerManager {
        this.imageName = imageName
        return this
    }

    fun setImageFolderName(folder: String?): PickerManager {
        this.folder = folder
        return this
    }

    fun setCustomizedUcrop(x: Double, y: Double): PickerManager {
        xScale = x.toFloat()
        yScale = y.toFloat()
        return this
    }
}