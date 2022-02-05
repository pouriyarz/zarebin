package com.example.gallery.di.component

import com.example.gallery.di.module.TempModule
import com.example.gallery.di.scope.TempScope
import com.example.gallery.util.imagepicker.TempActivity
import dagger.Component

@Component(
    modules = [TempModule::class]
)
@TempScope
interface TempComponent {
    fun inject(tempActivity: TempActivity)

    @Component.Factory
    interface Factory {
        fun create(): TempComponent
    }
}