package com.example.gallery.di.component

import com.example.gallery.di.module.GalleryModule
import com.example.gallery.di.scope.PickerBottomSheetScope
import com.example.gallery.ui.GalleryActivity
import dagger.Component

@PickerBottomSheetScope
@Component(
    modules = [
        GalleryModule::class
    ]
)
interface GalleryComponent {

    fun inject(galleryActivity: GalleryActivity)

    @Component.Factory
    interface Factory {
        fun create(): GalleryComponent
    }
}