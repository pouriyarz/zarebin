package com.example.sharepreferences.factory

import com.example.context.factory.ContextFactory
import com.example.dependencyinjection.ComponentFactory
import com.example.sharepreferences.component.DaggerSharedPreferencesComponent
import com.example.sharepreferences.component.SharedPreferencesComponent

object SharedPreferencesFactory : ComponentFactory<SharedPreferencesComponent>() {
    override fun create(): SharedPreferencesComponent {
        return DaggerSharedPreferencesComponent.factory().create(ContextFactory.create())
    }
}