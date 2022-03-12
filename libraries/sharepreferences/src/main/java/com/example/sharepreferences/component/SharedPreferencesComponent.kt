package com.example.sharepreferences.component

import android.content.SharedPreferences
import com.example.context.component.ContextComponent
import com.example.dependencyinjection.libraries.LibrariesScope
import com.example.sharepreferences.module.SharedPreferencesModule
import dagger.Component

@LibrariesScope
@Component(
    dependencies = [ContextComponent::class],
    modules = [SharedPreferencesModule::class]
)
interface SharedPreferencesComponent {

    fun provideSharedPreferences(): SharedPreferences

    @Component.Factory
    interface Factory {
        fun create(contextComponent: ContextComponent): SharedPreferencesComponent
    }
}