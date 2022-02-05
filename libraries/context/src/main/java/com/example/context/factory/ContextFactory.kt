package com.example.context.factory

import android.app.Application
import com.example.context.component.ContextComponent
import com.example.context.component.DaggerContextComponent
import com.example.dependencyinjection.ComponentFactory

object ContextFactory : ComponentFactory<ContextComponent>() {

    lateinit var mApplication: Application

    override fun create(): ContextComponent {
        return DaggerContextComponent.factory().create(mApplication)
    }
}