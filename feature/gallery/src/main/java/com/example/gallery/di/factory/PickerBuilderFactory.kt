package com.example.gallery.di.factory

import com.example.dependencyinjection.ComponentFactory
import com.example.gallery.di.component.DaggerPickerBuilderComponent
import com.example.gallery.di.component.PickerBuilderComponent

object PickerBuilderFactory : ComponentFactory<PickerBuilderComponent>() {
    override fun create(): PickerBuilderComponent {
        return DaggerPickerBuilderComponent.factory().create()
    }
}