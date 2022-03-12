package com.example.sample.util

import android.app.Application
import com.example.context.factory.ContextFactory

class SampleApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        ContextFactory.mApplication = this
    }
}