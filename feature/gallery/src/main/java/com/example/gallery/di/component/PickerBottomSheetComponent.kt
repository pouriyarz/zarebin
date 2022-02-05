package com.example.gallery.di.component

import com.example.gallery.di.scope.PickerBottomSheetScope
import com.example.gallery.ui.fragments.ImagePickerDialogFragment
import com.example.image.component.GlideComponent
import dagger.Component

@Component(
    dependencies = [GlideComponent::class]
)
@PickerBottomSheetScope
interface PickerBottomSheetComponent {
    fun inject(imagePickerDialogFragment: ImagePickerDialogFragment)

    @Component.Factory
    interface Factory {
        fun create(
            glideComponent: GlideComponent
        ): PickerBottomSheetComponent
    }
}