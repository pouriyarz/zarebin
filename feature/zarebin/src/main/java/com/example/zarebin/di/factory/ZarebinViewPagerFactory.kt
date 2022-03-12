package com.example.zarebin.di.factory

import com.example.dependencyinjection.ComponentFactory
import com.example.image.factory.GlideFactory
import com.example.networking.factory.NetworkingFactory
import com.example.zarebin.di.component.DaggerZarebinViewPagerComponent
import com.example.zarebin.di.component.ZarebinViewPagerComponent

object ZarebinViewPagerFactory : ComponentFactory<ZarebinViewPagerComponent>() {
    override fun create(): ZarebinViewPagerComponent {
        return DaggerZarebinViewPagerComponent.factory().create(
            NetworkingFactory.create(),
            GlideFactory.create()
        )
    }
}