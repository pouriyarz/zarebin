package com.example.gallery.di.factory

import com.example.dependencyinjection.ComponentFactory
import com.example.gallery.di.component.DaggerPickerBottomSheetComponent
import com.example.gallery.di.component.PickerBottomSheetComponent

object PickerBottomSheetFactory : ComponentFactory<PickerBottomSheetComponent>() {
    override fun create(): PickerBottomSheetComponent {
        return DaggerPickerBottomSheetComponent.factory().create()
    }
}