package com.example.gallery.di.component

import com.example.gallery.di.module.PickerBuilderModule
import com.example.gallery.di.scope.PickerBuilderScope
import com.example.gallery.util.imagepicker.PickerBuilder
import dagger.Component

@Component(
    modules = [PickerBuilderModule::class]
)
@PickerBuilderScope
interface PickerBuilderComponent {
    fun inject(pickerBuilder: PickerBuilder)

    @Component.Factory
    interface Factory {
        fun create(): PickerBuilderComponent
    }
}