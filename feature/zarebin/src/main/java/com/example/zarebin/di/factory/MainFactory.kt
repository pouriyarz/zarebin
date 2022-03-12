package com.example.zarebin.di.factory

import com.example.dependencyinjection.ComponentFactory
import com.example.zarebin.di.component.DaggerMainComponent
import com.example.zarebin.di.component.MainComponent

object MainFactory : ComponentFactory<MainComponent>() {
    override fun create(): MainComponent {
        return DaggerMainComponent.factory().create()
    }
}