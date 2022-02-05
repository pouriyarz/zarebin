package com.example.gallery.di.component

import com.example.gallery.di.scope.PickerBottomSheetScope
import com.example.gallery.ui.fragments.ImagePickerDialogFragment
import dagger.Component

@Component
@PickerBottomSheetScope
interface PickerBottomSheetComponent {
    fun inject(imagePickerDialogFragment: ImagePickerDialogFragment)

    @Component.Factory
    interface Factory {
        fun create(): PickerBottomSheetComponent
    }
}