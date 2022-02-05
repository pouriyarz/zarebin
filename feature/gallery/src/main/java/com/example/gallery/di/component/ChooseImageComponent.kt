package com.example.gallery.di.component

import com.example.gallery.di.module.ChooseImageModule
import com.example.gallery.di.scope.ChooseImageScope
import com.example.gallery.ui.fragments.ChooseImageFragment
import com.example.image.component.GlideComponent
import dagger.Component

@Component(
    dependencies = [GlideComponent::class],
    modules = [ChooseImageModule::class]
)
@ChooseImageScope
interface ChooseImageComponent {
    fun inject(chooseImageFragment: ChooseImageFragment)

    @Component.Factory
    interface Factory {
        fun create(
            glideComponent: GlideComponent
        ): ChooseImageComponent
    }
}