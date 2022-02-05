package com.example.context.module

import android.app.Application
import android.content.Context
import com.example.context.qualifier.ApplicationContext
import com.example.context.scope.ContextScope
import dagger.Module
import dagger.Provides

@Module
object ContextModule {

    @Provides
    @ContextScope
    @ApplicationContext
    fun provideApplicationContext(application: Application): Context {
        return application
    }
}