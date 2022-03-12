package com.example.zarebin.di.factory

import com.example.dependencyinjection.ComponentFactory
import com.example.image.factory.GlideFactory
import com.example.networking.factory.NetworkingFactory
import com.example.zarebin.di.component.DaggerZarebinComponent
import com.example.zarebin.di.component.ZarebinComponent

object ZarebinFactory : ComponentFactory<ZarebinComponent>() {
    override fun create(): ZarebinComponent {
        return DaggerZarebinComponent.factory().create(
            NetworkingFactory.create(),
            GlideFactory.create()
        )
    }
}