package com.example.networking.component

import com.example.context.component.ContextComponent
import com.example.dependencyinjection.libraries.LibrariesScope
import com.example.networking.module.NetworkModule
import dagger.Component
import retrofit2.Retrofit

@LibrariesScope
@Component(
    dependencies = [ContextComponent::class],
    modules = [NetworkModule::class]
)
interface NetworkComponent {

    fun provideRetrofitBuilder(): Retrofit.Builder

    @Component.Factory
    interface Factory {
        fun create(contextComponent: ContextComponent): NetworkComponent
    }
}