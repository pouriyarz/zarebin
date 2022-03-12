package com.example.zarebin.di.component

import com.example.zarebin.di.module.MainModule
import com.example.zarebin.di.scope.MainScope
import com.example.zarebin.ui.MainActivity
import dagger.Component

@MainScope
@Component(
    modules = [
        MainModule::class
    ]
)
interface MainComponent {

    fun inject(mainActivity: MainActivity)

    @Component.Factory
    interface Factory {
        fun create(): MainComponent
    }
}