package com.example.imagepicker.util

import android.app.Application
import com.example.context.factory.ContextFactory

class ImagePickerApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        ContextFactory.mApplication = this
    }
}