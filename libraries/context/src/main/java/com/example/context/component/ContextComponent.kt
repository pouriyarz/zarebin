package com.example.context.component

import android.app.Application
import android.content.Context
import com.example.context.module.ContextModule
import com.example.context.qualifier.ApplicationContext
import com.example.context.scope.ContextScope
import dagger.BindsInstance
import dagger.Component

@ContextScope
@Component(modules = [ContextModule::class])
interface ContextComponent {

//    @ApplicationContext
//    fun provideApplication(): Application

    @ApplicationContext
    fun provideApplicationContext(): Context

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance application: Application): ContextComponent
    }
}