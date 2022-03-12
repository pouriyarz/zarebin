package com.example.networking.factory

import com.example.context.factory.ContextFactory
import com.example.dependencyinjection.ComponentFactory
import com.example.networking.component.NetworkComponent
import com.example.networking.component.DaggerNetworkComponent

object NetworkingFactory : ComponentFactory<NetworkComponent>() {
    override fun create(): NetworkComponent {
        return DaggerNetworkComponent.factory().create(ContextFactory.create())
    }
}