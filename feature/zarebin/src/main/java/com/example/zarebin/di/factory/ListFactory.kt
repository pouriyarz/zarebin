package com.example.zarebin.di.factory

import com.example.dependencyinjection.ComponentFactory
import com.example.image.factory.GlideFactory
import com.example.networking.factory.NetworkingFactory
import com.example.zarebin.di.component.DaggerListComponent
import com.example.zarebin.di.component.ListComponent

object ListFactory : ComponentFactory<ListComponent>() {
    override fun create(): ListComponent {
        return DaggerListComponent.factory().create(
            NetworkingFactory.create(),
            GlideFactory.create()
        )
    }
}