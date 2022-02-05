package com.example.gallery.di.factory

import com.example.dependencyinjection.ComponentFactory
import com.example.gallery.di.component.DaggerPickerBottomSheetComponent
import com.example.gallery.di.component.PickerBottomSheetComponent
import com.example.image.factory.GlideFactory

object PickerBottomSheetFactory : ComponentFactory<PickerBottomSheetComponent>() {
    override fun create(): PickerBottomSheetComponent {
        return DaggerPickerBottomSheetComponent.factory().create(
            GlideFactory.create()
        )
    }
}