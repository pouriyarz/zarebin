package com.example.gallery.di.module

import com.example.gallery.util.imagepicker.GlobalHolder
import dagger.Module
import dagger.Provides

@Module
object PickerBuilderModule {

    @Provides
    fun provideGlobalHolder(): GlobalHolder {
        return GlobalHolder.getInstance()
    }
}