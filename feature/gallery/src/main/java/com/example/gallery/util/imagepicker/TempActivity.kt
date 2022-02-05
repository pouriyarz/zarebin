package com.example.gallery.util.imagepicker

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import com.example.base.BaseActivity
import com.example.gallery.R
import com.example.gallery.databinding.TempActivityBinding
import com.example.gallery.di.component.TempComponent
import com.example.gallery.di.factory.TempFactory
import com.yalantis.ucrop.UCrop.REQUEST_CROP
import javax.inject.Inject

class TempActivity : BaseActivity<TempActivityBinding>(R.layout.temp_activity) {
    @Inject
    lateinit var globalHolder: GlobalHolder
    private var pickerManager: PickerManager? = null
    private var tempComponent: TempComponent? = null

    override fun getViewBinding(): TempActivityBinding = TempActivityBinding.inflate(layoutInflater)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        pickerManager = globalHolder.getPickerManager()
        pickerManager?.setActivity(this@TempActivity)
        pickerManager?.pickPhotoWithPermission()
    }

    override fun inject() {
        tempComponent = TempFactory.create().also {
            it.inject(this)
        }
    }

    public override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode != RESULT_OK) {
            finish()
            return
        } else {
            when (requestCode) {
                PickerManager.REQUEST_CODE_SELECT_IMAGE -> {
                    val uri: Uri? = if (data != null) data.data else pickerManager?.getImageFile()
                    pickerManager?.setUri(uri)
                    pickerManager?.startCropActivity()
                }
                REQUEST_CROP -> if (data != null) {
                    pickerManager?.handleCropResult(data)
                }
                else -> {
                    finish()
                }
            }
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray,
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == PickerManager.REQUEST_CODE_IMAGE_PERMISSION) pickerManager?.handlePermissionResult(
            grantResults
        ) else finish()
    }

    override fun release() {
        tempComponent = null
    }
}
