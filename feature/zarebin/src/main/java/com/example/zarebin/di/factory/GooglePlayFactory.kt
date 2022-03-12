package com.example.zarebin.di.factory

import com.example.dependencyinjection.ComponentFactory
import com.example.image.factory.GlideFactory
import com.example.networking.factory.NetworkingFactory
import com.example.zarebin.di.component.DaggerGooglePlayComponent
import com.example.zarebin.di.component.GooglePlayComponent

object GooglePlayFactory : ComponentFactory<GooglePlayComponent>() {
    override fun create(): GooglePlayComponent {
        return DaggerGooglePlayComponent.factory().create(
            NetworkingFactory.create(),
            GlideFactory.create()
        )
    }
}