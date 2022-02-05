package com.example.gallery.di.factory

import com.example.dependencyinjection.ComponentFactory
import com.example.gallery.di.component.DaggerTempComponent
import com.example.gallery.di.component.TempComponent

object TempFactory : ComponentFactory<TempComponent>() {
    override fun create(): TempComponent {
        return DaggerTempComponent.factory().create()
    }
}