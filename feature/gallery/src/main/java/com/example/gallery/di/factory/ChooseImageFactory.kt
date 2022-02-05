package com.example.gallery.di.factory

import com.example.dependencyinjection.ComponentFactory
import com.example.gallery.di.component.ChooseImageComponent
import com.example.gallery.di.component.DaggerChooseImageComponent
import com.example.image.factory.GlideFactory

object ChooseImageFactory : ComponentFactory<ChooseImageComponent>() {
    override fun create(): ChooseImageComponent {
        return DaggerChooseImageComponent.factory().create(
            GlideFactory.create()
        )
    }
}