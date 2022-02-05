package com.example.image.component

import com.bumptech.glide.RequestManager
import com.example.context.component.ContextComponent
import com.example.dependencyinjection.libraries.LibrariesScope
import com.example.image.module.GlideModule
import dagger.Component

@LibrariesScope
@Component(
    dependencies = [ContextComponent::class],
    modules = [GlideModule::class]
)

interface GlideComponent {

    fun provideGlide(): RequestManager

    @Component.Factory
    interface Factory {
        fun create(contextComponent: ContextComponent): GlideComponent
    }
}