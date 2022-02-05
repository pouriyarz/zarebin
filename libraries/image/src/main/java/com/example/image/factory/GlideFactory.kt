package com.example.image.factory

import com.example.context.factory.ContextFactory
import com.example.dependencyinjection.ComponentFactory
import com.example.image.component.DaggerGlideComponent
import com.example.image.component.GlideComponent

object GlideFactory : ComponentFactory<GlideComponent>() {
    override fun create(): GlideComponent {
        return DaggerGlideComponent.factory().create(ContextFactory.create())
    }
}